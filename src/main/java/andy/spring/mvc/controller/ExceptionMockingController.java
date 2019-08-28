package andy.spring.mvc.controller;

import andy.spring.mvc.exceptions.AndyTestException;
import andy.spring.mvc.exceptions.DemoResponseStatusExceptionResolverException;
import andy.spring.mvc.exceptions.DemoSimpleMappingExceptionResolverException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZhangGuohua
 * @date 2017/10/29
 */
@Controller
public class ExceptionMockingController {


    /**
     * http://localhost:8080/mock-andy-test-exception
     * 1. 演示目的 : 这个控制器方法用于触发一个异常 AndyTestException,
     * 从而触发 GlobalControllerAdvice 中的 @ExceptionHandler 注解的异常处理控制器方法
     * 2. 此异常被任何 @ExceptionHandler 处理,所以不会出现 response.setError 动作
     *
     * @return
     */
    @RequestMapping(value = "/mock-andy-test-exception")
    @ResponseBody
    public String mockAndyTestException() {
        throw new AndyTestException();
    }

    /**
     * http://localhost:8080/mock-runtime-exception
     * 1. 用于触发 WhiteLabelError 页面,
     * 2. 此异常未被任何 @ExceptionHandler 或者 SimpleMappingExceptionResolver 处理,
     * 所以会出现 response.setError 动作
     *
     * @return
     */
    @RequestMapping(value = "/mock-runtime-exception")
    @ResponseBody
    public String mockExceptionForWhiteLabelErrorPage() {
        throw new RuntimeException();
    }

    /**
     * http://localhost:8080/mock-exception-with-response-status
     * 1. 触发一个异常 DemoResponseStatusExceptionResolverException,用于观察
     * ResponseStatusExceptionResolver 的应用
     * 2. 此异常未被任何 @ExceptionHandler 或者 SimpleMappingExceptionResolver 处理,
     * 所以会出现 response.setError 动作
     *
     * @return
     */
    @RequestMapping(value = "/mock-exception-with-response-status")
    @ResponseBody
    public String mockDemoResponseStatusExceptionResolverException() {
        throw new DemoResponseStatusExceptionResolverException();
    }

    /**
     * http://localhost:8080/mock-exception-for-simple-mapping-exception-resolver
     * 注意：有一个 freemarker 视图名字叫做 myErrorView, 该名字在 WebMvcConfig
     * 中定义 SimpleMappingExceptionResolver 时被使用
     * 1. 触发一个异常 DemoResponseStatusExceptionResolverException,用于观察
     * SimpleMappingExceptionResolver 的应用
     * 2. 此异常未被 SimpleMappingExceptionResolver 处理,
     * 所以不会出现 response.setError 动作
     *
     * @return
     */
    @RequestMapping(value = "/mock-exception-for-simple-mapping-exception-resolver")
    @ResponseBody
    public String mockDemoSimpleMappingExceptionResolverException() {
        throw new DemoSimpleMappingExceptionResolverException();
    }
}
