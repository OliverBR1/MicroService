package com.ms.email.dtos;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmailRecordDtoTest {
    @Test
    void testEmailRecordDtoCreation() {

        UUID userId = UUID.randomUUID();
        String emailTo = "example@example.com";
        String subject = "Test Subject";
        String text = "This is a test email.";

        EmailRecordDto emailRecord = new EmailRecordDto(
                userId, emailTo, subject, text);

        assertEquals(userId, emailRecord.userId());
        assertEquals(emailTo, emailRecord.emailTo());
        assertEquals(subject, emailRecord.subject());
        assertEquals(text, emailRecord.text());
    }
}
