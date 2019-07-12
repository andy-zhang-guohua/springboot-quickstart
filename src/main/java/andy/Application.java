package andy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ZhangGuohua
 */
@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("bean names:{}", applicationContext.getBeanDefinitionNames());

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        log.info("BeanPostProcessor count:{}", beanFactory.getBeanPostProcessorCount());
        log.info("|{}|{}|", "BeanPostProcessor类", "功能介绍");
        log.info("|{}|{}|", ":--", ":--");
        beanFactory.getBeanPostProcessors().forEach((bpp) -> {
            log.info("|`{}`|`TBD`|", bpp.getClass().getName());
        });

    }
}
