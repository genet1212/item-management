//package com.backend.service;
//
//import org.apache.logging.log4j.message.SimpleMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailSenderService {
//    @Autowired
//    private JavaMailSender mailSender;
//
//    public void sendEmail(String toEmail,
//                          String subject,
//                          String body){
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom("admin@example.com");
//        message.setTo(toEmail);
//        message.setText(body);
//        message.setSubject(subject);
//        mailSender.send(message);
//
//        System.out.println("Mail sent successfully...");
//
//    }
//}
