package org.example;

import jakarta.mail.*;

import java.util.Optional;

/**
 * Lector de Correo Electronico, se encarga de leer los correos electronicos, accediendo a la bandeja que tu le digas
 * @see java.lang.AutoCloseable
 * @version 1.0
 * @author Oscar
 */
public class LectorCorreo implements AutoCloseable {
    public final static String IMAP = "imap";
    public final static String POP_3 = "pop3";
    private final Store store;
    public LectorCorreo(Session session,String storeName) {
        try {
            this.store = session.getStore(storeName);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException("Error no existe el correo" + e);
        }
    }
    public LectorCorreo(Session session, String storeName, String userName, String password) {
        this(session,storeName);
        connect(userName,password);
    }
    public LectorCorreo(Session session) {
        this(session,IMAP);
    }

    /**
     * Se encarga de realizar la conexion con el servidor de correo
     * @param userName el nombre de usuario con el que realizas la conexion
     * @param password la contraseña con la que realizas la conexion
     * @return Verdadero si la conexion se realizo sino falso
     */
    public boolean connect(String userName, String password) {
        try {
            System.out.println("Conectando con usuario: " + userName);
            store.connect(userName,password);
            System.out.println("✓ Conexión establecida");
            return true;
        } catch (MessagingException e) {
            System.err.println("❌ Error de conexión: " + e.getMessage());
            return false;
        }
    }

    /**
     * Lee los mensajes
     * @param folder la carpeta de la que se leen los mensajes
     * @return un Optional con los mensajes, si ha habido un fallo al leerlos lo devolvera vacio
     */
    public Optional<Message[]> leerCorreosRecientes(String folder) {
        try (Folder folder1 = store.getFolder(folder)) {
            folder1.open(Folder.READ_ONLY);
            return Optional.of(folder1.getMessages());
        } catch (MessagingException e) {
            System.out.println("Problemas al intentar leer " +e);
            return Optional.empty();
        }
    }

    @Override
    public void close() throws Exception {
        if (store!=null && store.isConnected()) {
            try {
                store.close();
            } catch (MessagingException e) {
                throw new Exception("Fallo al cerrar la Store");
            }
        }
    }
}
