package com.nike.robocoach.robocoachapi;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Base64;

@SpringBootApplication
public class RobocoachApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobocoachApiApplication.class, args);
    }

}
