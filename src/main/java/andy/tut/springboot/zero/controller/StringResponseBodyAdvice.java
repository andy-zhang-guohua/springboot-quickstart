package andy.tut.springboot.zero.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 使用此方法观察 ResponseBodyAdvice 是如何工作的 ？
 * 1. 配置 : ResponseBodyAdvice 如何使用 ? -- 参考此类
 * 2. 导入 : ResponseBodyAdvice 被谁发现和管理 ? (使用者是谁)
 * 3. 应用 : ResponseBodyAdvice 何时被应用 ? 如何被应用 ?
 *
 * @author ZhangGuohua
 * @date 2019/08/16
 */
@Slf4j
@ControllerAdvice
public class StringResponseBodyAdvice implements ResponseBodyAdvice<String> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Class<?> type = returnType.getParameterType();
        if (!(type.isAssignableFrom(String.class))) {
            return false;
        }
        return true;
    }

    /**
     * 调用栈 :
     * beforeBodyWrite:36, StringResponseBodyAdvice (andy.tut.springboot.zero.controller)
     * beforeBodyWrite:21, StringResponseBodyAdvice (andy.tut.springboot.zero.controller)
     * processBody:141, RequestResponseBodyAdviceChain (org.springframework.web.servlet.mvc.method.annotation)
     * beforeBodyWrite:116, RequestResponseBodyAdviceChain (org.springframework.web.servlet.mvc.method.annotation)
     * writeWithMessageConverters:281, AbstractMessageConverterMethodProcessor (org.springframework.web.servlet.mvc.method.annotation)
     * handleReturnValue:180, RequestResponseBodyMethodProcessor (org.springframework.web.servlet.mvc.method.annotation)
     * handleReturnValue:82, HandlerMethodReturnValueHandlerComposite (org.springframework.web.method.support)
     * invokeAndHandle:119, ServletInvocableHandlerMethod (org.springframework.web.servlet.mvc.method.annotation)
     * invokeHandlerMethod:895, RequestMappingHandlerAdapter (org.springframework.web.servlet.mvc.method.annotation)
     * handleInternal:800, RequestMappingHandlerAdapter (org.springframework.web.servlet.mvc.method.annotation)
     * handle:87, AbstractHandlerMethodAdapter (org.springframework.web.servlet.mvc.method)
     * doDispatch:1038, DispatcherServlet (org.springframework.web.servlet)
     * doService:942, DispatcherServlet (org.springframework.web.servlet)
     * processRequest:1005, FrameworkServlet (org.springframework.web.servlet)
     * doPost:908, FrameworkServlet (org.springframework.web.servlet)
     * service:660, HttpServlet (javax.servlet.http)
     * service:882, FrameworkServlet (org.springframework.web.servlet)
     * service:741, HttpServlet (javax.servlet.http)
     * internalDoFilter:231, ApplicationFilterChain (org.apache.catalina.core)
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public String beforeBodyWrite(String body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body;
    }
}
