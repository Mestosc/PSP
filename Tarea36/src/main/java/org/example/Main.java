package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host","sandbox.smtp.mailtrap.io");
        properties.setProperty("mail.smtp.port","2525");
        properties.setProperty("mail.smtp.auth","true");
        properties.setProperty("mail.smtp.starttls.enable","true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("0af1aaf57c46d1","d7883d830d4009");
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("orodriguezcabaleiro@danielcastelao.org"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("destino@cualquiera.com"));
            String user = System.getenv("USER");
            message.setSubject("Prueba de Agente - " + Character.toUpperCase(user.charAt(0))+user.substring(1).toLowerCase());
            message.setText("El sistema de notificaciones esta activo");
            Transport.send(message);
            System.out.println("Mensaje enviado con exito abre la bandeja de entrada en MailTrap");
        } catch (MessagingException e) {
            System.out.println("Error en el mensaje " + e);
        }
        Properties properties1 = new Properties();
        properties1.setProperty("mail.imap.host","imap.mailtrap.io");
        properties1.setProperty("mail.imap.port","993");
        properties1.setProperty("mail.imap.ssl.enable","true");
        Session session1 = Session.getInstance(properties1);
        try (LectorCorreo correo = new LectorCorreo(session1,LectorCorreo.POP_3)) {
            if (correo.connect("","")) {
                correo.leerCorreosRecientes("INBOX").ifPresent(messages1 -> {
                    int longitud = Math.min(messages1.length,3);
                    for (int i = 0;i<longitud;i++) {
                        try {
                            System.out.println("Asunto " + messages1[i].getSubject());
                            System.out.println("Remitente " + messages1[i].getFrom()[0]);
                        } catch (MessagingException e) {
                            System.out.println("Problemas con los mensajes");
                        }
                    }
                });
        }} catch (Exception e) {
            System.out.println("Problemas con el cierre " + e);
        }
    }
}