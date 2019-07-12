package andy.zero.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * 该 BeanPostProcessor 过滤容器中的每个 bean 组件，检查其是否使用注解  @ConfigurationProperties,
 * 如果使用的话，日志输出其所使用的配置项的前缀。
 *
 * @author ZhangGuohua
 */
@Slf4j
@Component
public class ConfigurationPropertiesBeanDetectBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        // 获取某个bean上使用的注解 ConfigurationProperties , 获取对应的配置属性的前缀
        ConfigurationProperties annotation = getAnnotation(bean, ConfigurationProperties.class);
        if (annotation == null) {
            return bean;
        }

        ResolvableType beanType = getBeanType(bean);
        log.info("|`{}`|`{}`|", beanType.getType().getTypeName(), annotation.prefix());

        return bean;
    }

    private ResolvableType getBeanType(Object bean) {
        return ResolvableType.forClass(bean.getClass());
    }

    private <A extends Annotation> A getAnnotation(Object bean, Class<A> type) {
        A annotation = AnnotationUtils.findAnnotation(bean.getClass(), type);
        return annotation;
    }
}
