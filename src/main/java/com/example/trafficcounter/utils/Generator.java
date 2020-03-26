package com.example.trafficcounter.utils;

import java.util.Random;

public class Generator {

    public static Integer randomInt() {
        return randomInt(0, 10000);
    }

    public static int randomInt(int l, int r) {
        if (l > r)
            return 0;
        return new Random().nextInt(r - l) + l;
    }

    public static String randomString() {
        return randomString(7);
    }

    public static String randomString(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(randomLetter());
        }
        return builder.toString();
    }

    private static char randomLetter() {
        return (char)(new Random().nextInt(26) + 'a');
    }
}
