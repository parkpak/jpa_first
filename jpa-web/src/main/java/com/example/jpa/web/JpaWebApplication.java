package com.example.jpa.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.jpa.common.model.repository")
@ComponentScan("com.example.jpa")
public class JpaWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaWebApplication.class, args);
    }

}
