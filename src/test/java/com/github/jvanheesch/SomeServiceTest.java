package com.github.jvanheesch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SomeServiceTest {
    @Test
    public void testTrue() {
        SomeService someService = new SomeService();
        boolean actual = someService.returnInput(false);
        assertTrue(actual);
    }

    @Test
    void testFalse() {
        SomeService someService = new SomeService();
        boolean actual = someService.returnInput(false);
        assertFalse(actual);
    }
}
