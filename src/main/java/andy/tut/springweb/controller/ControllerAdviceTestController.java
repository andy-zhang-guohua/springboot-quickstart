package andy.tut.springweb.controller;

import andy.tut.springweb.exceptions.AndyTestException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZhangGuohua
 * @date 2017/10/29
 */
@Controller
public class ControllerAdviceTestController {


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


}
