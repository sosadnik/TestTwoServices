package com.mycompany.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomValueGeneratorService {

    public String randomString() {
        int len = 10;
        char[] str = new char[100];

        for (int i = 0; i < len; i++) {
            str[i] = (char) (((int) (Math.random() * 26)) + (int) 'A');
        }

        return (new String(str, 0, len));
    }

    public double randomDouble() {
        Random random = new Random();
        return  random.nextDouble();
    }

    public Long randomLong() {
        Random random = new Random();
        return random.nextLong();
    }

    public boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
