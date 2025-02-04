package com.carehive.services;


public interface MailService {

	public void sendPasswordResetEmail(String toEmail, String token);

}
