package com.ms.email.enuns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatusEmailTest {

    @Test
    void EnumValues(){
        assertEquals(StatusEmail.SENT, StatusEmail.valueOf("SENT"));
        assertEquals(StatusEmail.ERROR, StatusEmail.valueOf("ERROR"));
    }
}
