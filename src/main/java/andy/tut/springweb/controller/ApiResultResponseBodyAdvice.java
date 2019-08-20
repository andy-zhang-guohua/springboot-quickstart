package andy.tut.springweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDateTime;

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
public class ApiResultResponseBodyAdvice implements ResponseBodyAdvice<ApiResult> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Class<?> type = returnType.getParameterType();
        if (!(type.isAssignableFrom(ApiResult.class))) {
            return false;
        }
        return true;
    }

    @Override
    public ApiResult beforeBodyWrite(ApiResult body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        body.setResponseTime(LocalDateTime.now());
        return body;
    }
}
