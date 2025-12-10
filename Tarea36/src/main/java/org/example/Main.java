package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

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
    }
}