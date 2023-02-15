package com.programming.EmailApiDemo;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailTemplate {
    public static void main(String[] args) {
        String fromadd = "xxxxxxx@gmail.com";
        String toadd = "xxxxxxx@gmail.com";
        String ccadd = "xxxxxxxx@gmail.com";
        String msgbody = "Send Gmail with Api Demo";
        try {
            SendmailWithAtt(fromadd,toadd,ccadd,msgbody);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void SendmailWithoutAtt(String fromaddress,String toaddress,String ccaddress,String msgbody) throws MessagingException {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("xxxxxx@gmail.com", "xxxxxxxxxxxxx");
            }
        });
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(fromaddress);
        msg.addRecipients(Message.RecipientType.TO, toaddress);
        msg.addRecipients(Message.RecipientType.CC, ccaddress);
        msg.setSubject("Geekster Email Demo");
        msg.setText(msgbody);

        Transport.send(msg);
        System.out.print("Sent successfully.....");
    }
    public static void SendmailWithAtt(String fromaddress,String toaddress,String ccaddress,String msgbody) throws MessagingException, IOException {
        Session session = getSession();

        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(fromaddress);
        msg.addRecipients(Message.RecipientType.TO, toaddress);
        msg.addRecipients(Message.RecipientType.CC, ccaddress);
        msg.setSubject("Geekster Email Demo With Attachment");
        msg.setText(msgbody);


        String path = "C:\\Users\\master\\Downloads\\6548.png";
        MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart bodytext = new MimeBodyPart();
        MimeBodyPart bodyattachment = new MimeBodyPart();
        bodytext.setText(msgbody);

        File file = new File(path);
        bodyattachment.attachFile(file);
        multipart.addBodyPart(bodytext);
        multipart.addBodyPart(bodyattachment);
        msg.setContent(multipart);
        Transport.send(msg);
        System.out.print("Sent successfully....");
    }

    private static Session getSession() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication("xxxxxxxx@gmail.com","xxxxxxxxxx");
            }
        });
        return session;
    }
}

