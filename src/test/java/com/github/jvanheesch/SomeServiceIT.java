package com.github.jvanheesch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeServiceIT {
    @Test
    public void getSomeString() {
        SomeService someService = new SomeService();
        String actual = someService.getSomeString();
        assertEquals(actual, "DEF");
    }
}
