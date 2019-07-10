package andy.zero.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.EntityManagerBeanDefinitionRegistrarPostProcessor;

@EntityScan(basePackages = {"andy.zero","andy.one"})
@EnableJpaRepositories(basePackages = {"andy.zero","andy.one"})
@Configuration
public class JPAConfig {
    EntityManagerBeanDefinitionRegistrarPostProcessor entityManagerBeanDefinitionRegistrarPostProcessor;
}
