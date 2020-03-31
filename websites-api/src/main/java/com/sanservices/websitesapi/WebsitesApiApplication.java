package com.sanservices.websitesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sanservices")
public class WebsitesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsitesApiApplication.class, args);
    }

}
