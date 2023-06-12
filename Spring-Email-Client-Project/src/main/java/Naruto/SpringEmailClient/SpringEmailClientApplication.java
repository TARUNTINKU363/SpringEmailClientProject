package Naruto.SpringEmailClient;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailClientApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	// NOTE : when the application is ready the event will be triggered !!

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

//		emailSenderService.sendSimpleEmail("taruntinku363@gmail.com","This is email body!!","Spring Boot Email Application !");

		emailSenderService.sentEmailwithAttachment(
				"taruntinku363@gmail.com","This is Email body",
				"This mail has attachment",
				"C:/Users/91829/Downloads/database.pdf"
		);

	}

}
