package com.isamrs.backend.config;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); // Use the correct SMTP host
        mailSender.setPort(587); // Port for TLS
        mailSender.setUsername(""); // Your Gmail email address
        mailSender.setPassword(""); // Your Gmail password

        // Configure additional properties for TLS and authentication
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true"); // Enable debugging for troubleshooting

        return mailSender;
    }
    
}
