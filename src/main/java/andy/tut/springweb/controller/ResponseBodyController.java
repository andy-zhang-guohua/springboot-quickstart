package andy.tut.springweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author ZhangGuohua
 * @date 2019-08-16
 * <p>
 * 该控制器用于测试：
 * 1. @ResponseBody 和 ResponseBodyAdvice
 */
@Slf4j
@RestController
public class ResponseBodyController {



    /**
     * 此方法使用了 @ResponseBody 注解参数，返回值类型为 ApiResult
     * 此方法可用于观察 @ResponseBody 和 RequestBodyAdvice (例子 : MyRequestBodyAdvice) 是如何工作的
     * @param data
     * @return
     */
    @RequestMapping(value = "/response-body-api-result")
    public ApiResult demoResponseBodyApiResult(@RequestBody String data) {
        return new ApiResult(data, LocalDateTime.now());
    }
    /**
     * 此方法使用了 @ResponseBody 注解参数，返回值类型为 ApiResult
     * 此方法可用于观察 @ResponseBody 和 RequestBodyAdvice (例子 : MyRequestBodyAdvice) 是如何工作的
     * 观察方法 :
     * 1. 请求端请使用 POST 模式，工具可以使用 Chrome 浏览器 PostMan 或者 Restlet Client 插件,
     * 2. 访问 Content-Type: application/json 或者 text/plain 均可
     * 3. 请求体使用JSON或者非JSON均可,例子 :
     *  {
     *      "title":"New version of Elasticsearch released!",
     *      "content":"Version 1.0 released today!",
     *      "tags":["announce","elasticsearch","release"]
     *  }
     * 4.参数 data 类型 String
     * 5. 在该方法 return 语句设置断点
     * 观察结果 :
     * 1. MappingJackson2HttpMessageConverter 会被使用
     * 2. 该方法 return 语句上的断点位于:
     *      DispatcherServlet#doDispatch
     *      ==> RequestMappingHandlerAdapter#handleInternal
     *      ==> RequestMappingHandlerAdapter#invokeHandlerMethod
     *      ==> ServletInvocableHandlerMethod#invokeAndHandle
     *      ==> InvocableHandlerMethod#getMethodArgumentValues
     *      ==> RequestResponseBodyMethodProcessor#resolveArgument
     *3. 以上组合是典型的 POST JSON 正常情况的例子
     * @param data
     * @return
     */
    @RequestMapping(value = "/response-body-string")
    public String demoResponseBodyString(@RequestBody String data) {
        return new ApiResult(data, LocalDateTime.now()).toString()+" IN STRING FORMAT";
    }
}
