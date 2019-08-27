package andy.spring.mvc.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

/**
 * 这个异常上使用 @ResponseStatus 注解
 * 演示 ResponseStatusExceptionResolver  的应用
 *
 * @author ZhangGuohua
 * @date 2019-08-20
 */
@ResponseStatus(value = CONFLICT, reason = "test Http Status 409")
public class DemoResponseStatusExceptionResolverException extends RuntimeException {
}
