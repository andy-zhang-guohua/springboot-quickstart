package andy.zero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@EntityScan(basePackages = {"andy.zero","andy.one"})
// 注意，这里没有写明 andy.zero, 但是 andy.zero 也能被识别，因为当前类在这个包中
@EnableJpaRepositories(basePackages = {"andy.one"})
@SpringBootApplication
public class Application {
    public static void main(String[] args)   {
        SpringApplication.run(Application.class, args);
    }
}
