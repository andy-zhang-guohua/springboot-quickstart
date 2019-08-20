package andy.spring.mvc.config;

import andy.spring.mvc.controller.WelcomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 本配置文件用于演示定义用于 Controller 的 bean， 这些 bean 实现了接口 Controller，
 * 会被 Spring MVC HandlerMapping BeanNameUrlHandlerMapping 组件发现和进行映射登记,
 * 最终会在访问 URL /welcome 时匹配到 SimpleControllerHandlerAdapter
 */
@Configuration
public class ControllerBeanConfig {
    /**
     * 这里定义一个 web controller bean, 注意 :
     * 1. 该 bean 实现了接口 Controller,
     * 2. 该 bean 没有使用注解 @Controller,
     * (如果使用了注解@Controller,就会被RequestMappingHandlerMapping接管，而不是由BeanNameUrlHandlerMapping处理)
     * 3. 映射到匹配 welcome* 的url
     * @return
     */
    @Bean(name = "/welcome*")
    public WelcomeController beanWelcomeController() {
        return new WelcomeController();
    }
}
