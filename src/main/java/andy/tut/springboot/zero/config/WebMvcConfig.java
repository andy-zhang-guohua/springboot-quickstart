package andy.tut.springboot.zero.config;

import freemarker.core.XHTMLOutputFormat;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// 注意：
// 1. 在 SpringBoot Web MVC 应用中,一旦使用了 @EnableWebMvc,
// 则 WebMvcAutoConfiguration 自动配置提供的默认机制会失效，
// 会转而使用此处  @EnableWebMvc + WebMvcConfigurer 的 Spring MVC 配置。
// 2. 如果你只是想在缺省 WebMvcAutoConfiguration 机制之上做部分增量性定制，
// 这里使用 WebMvcConfigurer 但不要使用  @EnableWebMvc 。
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 静态资源文件映射配置
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 注意 :
        // 1. addResourceHandler 参数可以有多个
        // 2. addResourceLocations 参数可以是多个，可以混合使用 file: 和 classpath : 资源路径
        // 3. addResourceLocations 参数中资源路径必须使用 / 结尾，如果没有此结尾则访问不到

        // 映射到多个静态资源路径到某个URL pattern
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/MyStatic/","file:/web_starter_repo/");

        // 映射到jar包内的静态文件(真正的静态文件，应用运行时，这些文件无业务逻辑，也不能被替换或者修改)
        //registry.addResourceHandler("/my-static/**").addResourceLocations("classpath:/MyStatic/").resourceChain(true);
    }

    /**
     * 初始化配置 ViewControllerRegistry registry
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 请求匹配地址 /absent* 时,响应 HTTP代码403给浏览器端
        registry.addStatusController("/absent*", HttpStatus.FORBIDDEN);
        // 请求匹配地址 /home* 时,浏览器同意跳转到 /
        registry.addRedirectViewController("/home*", "/");
        // 请求匹配地址 /fixed* 时，统一使用视图 fixed_content 进行渲染
        registry.addViewController("/fixed*").setViewName("fixed_content");
    }


    //////////////////// 以下区域是 Freemarker 相关的配置 ////////////////////
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
        factory.setTemplateLoaderPaths("classpath:/templates/");
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