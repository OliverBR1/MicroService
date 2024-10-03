package com.ms.email.services;

import com.ms.email.enuns.StatusEmail;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.UUID;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmailServiceTest {

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private JavaMailSender emailSender;

    @InjectMocks
    private EmailService emailService;

    private EmailModel emailModel;

    @BeforeEach
    void setUp() {
        emailModel = new EmailModel();
        emailModel.setUserId(UUID.randomUUID());
        emailModel.setEmailTo("destinatario@example.com");
        emailModel.setSubject("Assunto");
        emailModel.setText("Corpo do email");
    }

    @Test
    void testSendEmailSuccess() {
        EmailModel result = emailService.sendEmail(emailModel);

        verify(emailSender, times(1)).send(any(SimpleMailMessage.class));
        verify(emailRepository, times(1)).save(emailModel);
        assertThat(result.getStatusEmail()).isEqualTo(StatusEmail.SENT);
        assertThat(result.getSendDateEmail()).isNotNull();
    }

    @Test
    void testSendEmailFailure() {
        doThrow(new MailException("Falha ao enviar email") {}).when(emailSender).send(any(SimpleMailMessage.class));

        EmailModel result = emailService.sendEmail(emailModel);

        verify(emailSender, times(1)).send(any(SimpleMailMessage.class));
        verify(emailRepository, times(1)).save(emailModel);
        assertThat(result.getStatusEmail()).isEqualTo(StatusEmail.ERROR);
    }
}
