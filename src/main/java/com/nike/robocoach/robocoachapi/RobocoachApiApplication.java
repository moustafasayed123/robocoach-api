package com.nike.robocoach.robocoachapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RobocoachApiApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RobocoachApiApplication.class, args);
    }

}
