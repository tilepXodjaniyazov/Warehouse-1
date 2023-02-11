package com.example.warehouse.Servis;

import java.nio.charset.Charset;
import java.util.Random;

public class Randoms {
    public String getRandom() {
        byte[] array = new byte[10];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }

    public String getRandomId(Integer length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}
