package org.example.hassoun_school.Controller;

import org.example.hassoun_school.Entity.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody ContactForm contactForm) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("bessembenben2023@gmail.com");
        mailMessage.setSubject("Nouveau message de contact");
        mailMessage.setText("Nom: " + contactForm.getName() + "\n" +
                "Email: " + contactForm.getEmail() + "\n" +
                "Téléphone: " + contactForm.getPhone() + "\n" +
                "Message: " + contactForm.getMessage());

        javaMailSender.send(mailMessage);

        return ResponseEntity.ok("Message envoyé avec succès");
    }
}

