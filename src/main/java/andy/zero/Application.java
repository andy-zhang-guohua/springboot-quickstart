package andy.zero;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    ConfigurableWebApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("bean names:{}", applicationContext.getBeanDefinitionNames());
    }
}
