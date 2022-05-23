package com.abidevel.notification.notificationgateway.service.implementation;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.abidevel.notification.notificationgateway.Configuration.MailConfiguration;
import com.abidevel.notification.notificationgateway.service.EmailService;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailServiceImplementation implements EmailService {

    private final JavaMailSender javaMailSender;
    private final MailConfiguration mailConfiguration;

    public EmailServiceImplementation (JavaMailSender mailSender, MailConfiguration mailConfiguration) {
        this.javaMailSender = mailSender;
        this.mailConfiguration = mailConfiguration;
    }

    @Override
    public boolean sendEmail(String emailTo, String body, String subject) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            helper.addAttachment("CitizenBank.png", new ClassPathResource("static/CitizenBank.png"));
            helper.setTo(emailTo);
            helper.setText(body, true);
            helper.setSubject(subject);
            helper.setFrom(mailConfiguration.getEmailFrom());
            javaMailSender.send(message);
            return true;
        } catch (MailAuthenticationException authException) {
            log.error(authException.getMessage());
        } catch (MailSendException mailSendException) {
            log.error(mailSendException.getMessage());
        } catch (MailException mailException) {
            log.error(mailException.getMessage());
        } catch (MessagingException e) {
            log.error(e.getMessage());
        }
        return false;
    }
}
