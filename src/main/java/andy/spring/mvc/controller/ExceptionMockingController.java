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
     * 这个控制器方法用于触发一个异常 AndyTestException,
     * 从而触发 GlobalControllerAdvice 中的 @ExceptionHandler
     * 注解控制器方法
     * @return
     */
    @RequestMapping(value = "/mock-exception")
    @ResponseBody
    public String mockAndyTestException() {
        throw new AndyTestException();
    }

    /**
     * 用于触发 WhiteLabelError 页面
     * @return
     */
    @RequestMapping(value = "/mock-runtime-exception")
    @ResponseBody
    public String mockExceptionForWhiteLabelErrorPage() {
        throw new RuntimeException();
    }

    /**
     * 触发一个异常 DemoResponseStatusExceptionResolverException,用于观察
     * ResponseStatusExceptionResolver 的应用
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
     * 触发一个异常 DemoResponseStatusExceptionResolverException,用于观察
     * SimpleMappingExceptionResolver 的应用
     * @return
     */
    @RequestMapping(value = "/mock-exception-for-simple-mapping-exception-resolver")
    @ResponseBody
    public String mockDemoSimpleMappingExceptionResolverException() {
        throw new DemoSimpleMappingExceptionResolverException();
    }
}
