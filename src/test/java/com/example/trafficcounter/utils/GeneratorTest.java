package com.example.trafficcounter.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    @Test
    void randomStringWithLength() {
        int length = Generator.randomInt();
        String string = Generator.randomString(length);
        for (int i = 0; i < string.length(); i++)
            assertTrue(Character.isLowerCase(string.charAt(i)));
    }
}