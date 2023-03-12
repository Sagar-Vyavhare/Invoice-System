package mypackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Email;
import mypackage.services.EmailServiceImplementation;

@RestController
public class Email_controller {

	@Autowired
	EmailServiceImplementation email;
	
	@PostMapping("api/email")
	public String sendSimpleMail(@RequestBody Email e) {
		return email.SimpleEmail(e);
		}
}
