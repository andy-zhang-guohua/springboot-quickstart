package andy.tut.springboot.zero;

import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.core.XHTMLOutputFormat;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
//@EnableWebMvc // Adding this annotation to an @Configuration class imports the Spring MVC configuration from WebMvcConfigurationSupport
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Autowired
    ObjectMapper objectMapper;

    @Bean
    @Primary
    MappingJackson2HttpMessageConverter converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        return converter;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    //////////////////// 以下区域是 Freemarker 相关的配置 ////////////////////
    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=UTF-8");
        return resolver;
    }

    @Autowired
    @Bean
    public FreeMarkerConfig springFreeMarkerConfig(ServletContext servletContext) throws IOException, TemplateException {
        FreeMarkerConfigurer freemarkerConfig = configFreeMarkerConfigurer(servletContext);
        return freemarkerConfig;
    }

    private static FreeMarkerConfigurer configFreeMarkerConfigurer(ServletContext servletContext) throws IOException,
            TemplateException {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();

        FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
        factory.setTemplateLoaderPaths("classpath:/web/templates/");
        factory.setDefaultEncoding("UTF-8");
        Map<String, Object> variables = new HashMap<String, Object>();
        factory.setFreemarkerVariables(variables);

        freemarker.template.Configuration cfg = factory.createConfiguration();
        cfg.setNumberFormat("0.######");
        cfg.setDateFormat("yyyy-MM-dd");
        cfg.setTimeFormat("hh:mm:ss");
        cfg.setDateTimeFormat("yyyy-MM-dd hh:mm:ss");
        cfg.setOutputFormat(XHTMLOutputFormat.INSTANCE);


        Properties settings = new Properties();
        settings.put("default_encoding", "UTF-8");
        freeMarkerConfigurer.setFreemarkerSettings(settings);
        freeMarkerConfigurer.afterPropertiesSet();
        freeMarkerConfigurer.setConfiguration(cfg);

        return freeMarkerConfigurer;
    }

}