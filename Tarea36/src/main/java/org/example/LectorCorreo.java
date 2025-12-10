package org.example;

import jakarta.mail.*;

import java.util.Optional;

public class LectorCorreo implements AutoCloseable {
    public final static String IMAP = "imap";
    Store store;
    Session session;
    public LectorCorreo(Session session,String storeName) {
        this.session = session;
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
        if (store.isConnected()||store!=null) {
            try {
                store.close();
            } catch (MessagingException e) {
                System.out.println("Problemas con el cierre");
            }
        }
    }
}
