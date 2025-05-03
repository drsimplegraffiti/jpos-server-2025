package com.drsimple.jposspringboot;

import org.jpos.q2.Q2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JposspringbootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JposspringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Q2 q2 = new Q2();
//        Thread thread  = new Thread(q2);
//        thread.start();
        q2.start();
    }
}

