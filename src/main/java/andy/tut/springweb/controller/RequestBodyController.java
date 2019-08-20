package andy.tut.springweb.controller;

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
 */
@Slf4j
@Controller
public class RequestBodyController {



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
     * 4.参数 data 类型 Object
     * 5. 在该方法 return 语句设置断点
     * 观察结果 :
     * 1. MappingJackson2HttpMessageConverter 会被使用
     * 2. 该方法 return 语句上的断点位于:
     *      DispatcherServlet#doDispatch
     *      ==> RequestMappingHandlerAdapter#handleInternal
     *      ==> RequestMappingHandlerAdapter#invokeHandlerMethod
     *      ==> ServletInvocableHandlerMethod#invokeAndHandle
     *      ==> InvocableHandlerMethod#invokeForRequest
     *      ==> InvocableHandlerMethod#doInvoke
     *3. 以上组合是典型的 POST JSON 正常情况的例子
     *
     * 注意 :
     * 请变化以下三个参数观察 :
     * 1. 请求 Content-Type: application/json
     * 2. 请求体，
     * 3. 参数 data 类型
     * 测试组合 :
     * 1. application/json, 请求体 : 非json, data 类型 : Object => 错误 400
     * 2. text/plain, 请求体 : json, data 类型 : Object => 错误 415
     * 3. text/plain, 请求体 : 非 json, data 类型 : Object => 错误 415
     * 4. text/plain, 请求体 : json, data 类型 : String => OK (可自定义格式的使用组合)
     * 5. text/plain, 请求体 : 非json, data 类型 : String => OK (可自定义格式的使用组合)
     * @param data
     * @return
     */
    @RequestMapping(value = "/request-body")
    @ResponseBody
    public Object demoRequestBody(@RequestBody Object data) {
        return new ApiResult(data, LocalDateTime.now());
    }

}
