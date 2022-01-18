package com.andy.camunda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class RunProcessInCamunda {
    public static void main(String[] args) {
        SpringApplication.run(RunProcessInCamunda.class, args);
    }
}
