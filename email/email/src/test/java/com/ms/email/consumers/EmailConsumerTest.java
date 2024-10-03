package com.ms.email.consumers;

import com.ms.email.dtos.EmailRecordDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class EmailConsumerTest {

    @InjectMocks
    private EmailConsumer emailConsumer;

    @Mock
    private EmailService emailService;

    @Mock
    private EmailRecordDto emailRecordDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listenEmailQueue() {
        emailConsumer.listenEmailQueue(emailRecordDto);

        verify(emailService, times(1))
                .sendEmail(any(EmailModel.class));
    }

}