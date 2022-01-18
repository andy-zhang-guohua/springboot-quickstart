package com.andy.camunda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CamundaCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
      log.info("正在执行...");
    }
}
