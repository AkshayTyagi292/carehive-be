package com.carehive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailServiceImpl implements MailService {
	
	 @Autowired
	    private JavaMailSender mailSender;

	 @Override
	    public void sendPasswordResetEmail(String toEmail, String token) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("chetup988@gmail.com");
	        message.setTo(toEmail);
	        message.setSubject("Password Reset Request");
	        message.setText("To reset your password, click the following link: \n"
	                + "http://localhost:8081/user/resetPassword?token=" + token);

	        mailSender.send(message);
	    }

}
