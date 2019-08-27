package andy.spring.mvc.exceptions;

/**
 * 这个异常上不使用 @ResponseStatus 注解，配合 @ControllerAdvice 类中
 *  使用 @ExceptionHandler(AndyTestException.class) 注解的异常处理控制器方法
 *  共同演示 ExceptionHandlerExceptionResolver 的应用
 * @author ZhangGuohua
 * @date 2019-08-20
 */
public class AndyTestException extends RuntimeException {
}
