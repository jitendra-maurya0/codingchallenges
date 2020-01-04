package com.sample.question;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleTest {
    @Test
    void dummyTest() {
        Sample sample = new Sample();
        String value = sample.getValue();
        Assertions.assertEquals(value,"hello");

    }

}
