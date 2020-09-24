package com.mail.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.demo.model.User;
import com.mail.demo.service.MailService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/mail")
public class RegistrationController {

	@Autowired
	private MailService notificationService;

	//@Autowired
	//private User user;


	@PostMapping(value="/send-mail")
	public String send(@RequestBody User user) {


		//user.setEmailAddress(email); //Receiver's email address

		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}


	@PostMapping(value="send-mail-attachment")
	public String sendWithAttachment(@RequestBody User user ) throws MessagingException {


		
		//user.setEmailAddress(email); //Receiver's email address


		try {
			notificationService.sendEmailWithAttachment(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}
