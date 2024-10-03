package com.ms.email;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmailApplicationTests {

	@Test
	void voidMain() {
		EmailApplication.main(new String[] {});
	}

}
