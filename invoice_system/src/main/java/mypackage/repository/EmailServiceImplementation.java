package mypackage.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import mypackage.model.Email;

@Service
public class EmailServiceImplementation{

	@Autowired
	private JavaMailSender JavaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	public String SimpleEmail(Email mail){
		 try {
			 SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			  simpleMailMessage.setTo(mail.getRecipient());
			  simpleMailMessage.setSubject(mail.getSubject());
			  simpleMailMessage.setText(mail.getMsg());
			  JavaMailSender.send(simpleMailMessage);
			  return "mail send successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	
	
}
