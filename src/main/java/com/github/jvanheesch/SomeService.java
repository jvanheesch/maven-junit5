package com.github.jvanheesch;

import java.util.function.Consumer;

public class SomeService {
    public static void someMethodThatRequiredJava8() {
        Consumer<Object> consumer = x -> System.out.println(x);
    }

    public boolean returnInput(boolean input) {
        if (input) {
            return true;
        } else {
            return false;
        }
    }

    public String getSomeString() {
        return "ABC";
    }
}
