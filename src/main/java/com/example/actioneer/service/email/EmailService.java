package com.example.actioneer.service.email;

import com.example.actioneer.model.Item;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
public class EmailService {
    private final String username = "capsuleoftimeofcc@gmail.com";
    private final String psw = "Csicsiphp";

    public void sendEmail(Map<String, List<String>> emails) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, psw);
                    }
                });

        for (Map.Entry<String,List<String>> email: emails.entrySet()
        ) {
            try {
                javax.mail.Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("capsuleoftimeofcc@gmail.com"));
                message.setRecipients(
                        javax.mail.Message.RecipientType.TO,
                        InternetAddress.parse(email.getKey())
                );
                message.setSubject("On Sale Items from your List");
                StringBuilder msg = new StringBuilder();
                for (int i = 0; i< (email.getValue()).size();i++) {
                    msg.append((email.getValue()).get(i)).append("\n\n");
                }
                message.setText(msg.toString());
                Transport.send(message);

                System.out.println(new Date() +" Sent email to "+email.getKey());

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
