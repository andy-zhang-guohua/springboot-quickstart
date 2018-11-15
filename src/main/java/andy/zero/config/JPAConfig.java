package andy.zero.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"andy.zero","andy.one"})
@EnableJpaRepositories(basePackages = {"andy.zero"})
@Configuration
public class JPAConfig {
}
