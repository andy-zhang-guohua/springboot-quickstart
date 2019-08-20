package andy.spring.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import java.lang.reflect.Type;

/**
 * 使用此方法观察 RequestBodyAdvice 是如何工作的 ？
 * 1. 配置 : RequestBodyAdvice 如何使用 ? -- 参考此类
 * 2. 导入 : RequestBodyAdvice 被谁发现和管理 ? (使用者是谁)
 * 3. 应用 : RequestBodyAdvice 何时被应用 ? 如何被应用 ?
 *
 * @author ZhangGuohua
 * @date 2019/08/16
 */
@Slf4j
@ControllerAdvice
public class MyRequestBodyAdvice extends RequestBodyAdviceAdapter {
    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 调用栈 :
     * beforeBodyRead:33, MyRequestBodyAdvice (andy.tut.springboot.zero.controller)
     * beforeBodyRead:92, RequestResponseBodyAdviceChain (org.springframework.web.servlet.mvc.method.annotation)
     * readWithMessageConverters:203, AbstractMessageConverterMethodArgumentResolver (org.springframework.web.servlet.mvc.method.annotation)
     * readWithMessageConverters:157, RequestResponseBodyMethodProcessor (org.springframework.web.servlet.mvc.method.annotation)
     * resolveArgument:130, RequestResponseBodyMethodProcessor (org.springframework.web.servlet.mvc.method.annotation)
     * resolveArgument:126, HandlerMethodArgumentResolverComposite (org.springframework.web.method.support)
     * getMethodArgumentValues:166, InvocableHandlerMethod (org.springframework.web.method.support)
     * invokeForRequest:134, InvocableHandlerMethod (org.springframework.web.method.support)
     * invokeAndHandle:102, ServletInvocableHandlerMethod (org.springframework.web.servlet.mvc.method.annotation)
     * invokeHandlerMethod:895, RequestMappingHandlerAdapter (org.springframework.web.servlet.mvc.method.annotation)
     * handleInternal:800, RequestMappingHandlerAdapter (org.springframework.web.servlet.mvc.method.annotation)
     * handle:87, AbstractHandlerMethodAdapter (org.springframework.web.servlet.mvc.method)
     * doDispatch:1038, DispatcherServlet (org.springframework.web.servlet)
     * @param inputMessage
     * @param parameter
     * @param targetType
     * @param converterType
     * @return
     */
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter,
                                           Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("请求,RequestBody 读取前 : parameter={},targetType={},selectedConverterType={}", parameter, targetType, converterType);
        return inputMessage;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
                                Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        log.info("请求,RequestBody 读取后 : methodParameter={},targetType={},selectedConverterType={},body={}", parameter, targetType, converterType, body);
        return body;
    }
}
