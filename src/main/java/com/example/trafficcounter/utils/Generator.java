package com.example.trafficcounter.utils;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Generator {

    public static String randomString() {
        return randomString(7);
    }

    public static String randomString(int length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
