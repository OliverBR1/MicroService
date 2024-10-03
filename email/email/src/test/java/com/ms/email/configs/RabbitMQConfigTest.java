package com.ms.email.configs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@TestPropertySource(properties = "broker.queue.email.name=test-queue")
@SpringBootTest
class RabbitMQConfigTest {

    @InjectMocks
    private RabbitMQConfig rabbitMQConfig;

    @Mock
    private ObjectMapper objectMapper;

    @Value("${broker.queue.email.name}")
    private String queueName;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @SneakyThrows
    @Test
    void testMessageConverterBean() throws JsonProcessingException {
        when(objectMapper.readValue("{}", Object.class)).thenReturn(new Object());

        Jackson2JsonMessageConverter converter = rabbitMQConfig.messageConverter();
        assertNotNull(converter);
    }
}