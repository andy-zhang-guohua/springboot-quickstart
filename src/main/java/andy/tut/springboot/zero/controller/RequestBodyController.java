package andy.tut.springboot.zero.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * @author ZhangGuohua
 * @date 2019-08-16
 * <p>
 * 该控制器用于测试：
 * 1. @RequestBody 和 RequestBodyAdvice
 * 2. @ResponseBody 和 ResponseBodyAdvice
 */
@Slf4j
@Controller
public class RequestBodyController {

    @Data
    private static class MyResponseWrapper {
        LocalDateTime requestTime;
        Object requestData;

        MyResponseWrapper(Object requestData, LocalDateTime requestTime) {
            this.requestData = requestData;
            this.requestTime = requestTime;
        }
    }

    /**
     * 此方法使用了 @RequestBody 注解参数，
     * 此方法可用于观察 @RequestBody 和 RequestBodyAdvice (例子 : MyRequestBodyAdvice) 是如何工作的
     * 观察方法 :
     * 1. 请求端请使用 POST 模式，工具可以使用 Chrome 浏览器 PostMan 或者 Restlet Client 插件,
     * 2. 访问 Content-Type: application/json
     * 3. 请求体使用JSON,例子 :
     *  {
     *      "title":"New version of Elasticsearch released!",
     *      "content":"Version 1.0 released today!",
     *      "tags":["announce","elasticsearch","release"]
     *  }
     * 4. 在该方法 return 语句设置断点
     * 观察结果 :
     * 1. MappingJackson2HttpMessageConverter 会被使用
     * 2. 该方法 return 语句上的断点位于:
     *      DispatcherServlet#doDispatch
     *      ==> RequestMappingHandlerAdapter#handleInternal
     *      ==> RequestMappingHandlerAdapter#invokeHandlerMethod
     *      ==> ServletInvocableHandlerMethod#invokeAndHandle
     *      ==> InvocableHandlerMethod#getMethodArgumentValues
     *      ==> RequestResponseBodyMethodProcessor#resolveArgument
     *
     * 注意 :
     * 请变化以下三个参数观察 :
     * 1. 请求不使用 Content-Type: application/json 而是 Content-Type: text/plain,
     * 2. 请求体不为 json 内容，
     * 3. 参数 data 类型使用 String, 而不是 Object
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/request-body")
    @ResponseBody
    public Object demoRequestBody(@RequestBody Object data) {
        return new MyResponseWrapper(data, LocalDateTime.now());
    }

}
