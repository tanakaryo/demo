package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTest {
    
    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void encode() {
        System.out.println(encoder.encode("pass"));
		System.out.println(encoder.encode("password"));
    }
}
