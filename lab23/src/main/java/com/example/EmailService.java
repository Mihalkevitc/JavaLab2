package com.example;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Async
    public void sendEmail(String to, String subject, String body) {
        // Настройки подключения к почтовому серверу
        String host = "smtp.yandex.ru";
        int port = 465;
        String username = "Mihalkevitc.23V@yandex.ru"; //Кто отправляет
        String password = "jrqetdxmplyjqyhj";
        String recipient = to; // адрес получателя

        // Настройка свойств JavaMail
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        // Создание сессии
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Создание сообщения
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            // Отправка сообщения
            Transport.send(message);

            System.out.println("Письмо успешно отправлено.");
            logger.info("Email sent successfully to: {}", to);
        } catch (MessagingException e) {
            System.out.println("Ошибка при отправке письма:");
            logger.error("Error occurred while sending email to {}: {}", to, e.getMessage());
            e.printStackTrace();
        }
    }
}
