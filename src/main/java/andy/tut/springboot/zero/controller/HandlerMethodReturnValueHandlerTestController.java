package andy.tut.springboot.zero.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于测试各种控制器方法返回值处理器的效果
 *
 * @author ZhangGuohua
 * @date 2019/08/19
 */
@Controller
public class HandlerMethodReturnValueHandlerTestController {

    /**
     * 实验跳转到根路径，观察此时view name ==> View 的解析过程，以及所使用的 View 对象是什么：是 RedirectView
     *
     * 此方法对应使用的 HandlerMethodReturnValueHandler 会是 ViewNameMethodReturnValueHandler,
     * 相应状态字会是 302, 头部 Location 会是类似 http://localhost:8080/ 这样的值
     *
     * @return
     */
    @RequestMapping(value = "/redirect-home")
    public String redirectToHome() {
        return "redirect:/";
    }

    /**
     * 用于观察 HttpHeadersReturnValueHandler 的应用效果
     * 此请求可以使用 GET，POST，响应状态字会是 200， 没有响应体，响应头部会如下所示 :
     * names:	Andy
     * names:	Cindy
     * names:	Dodge
     * Content-Length:	0 byte
     * Date:	Mon, 19 Aug 2019 08:02:54 GMT
     * @return
     */
    @RequestMapping(value = "/http-headers")
    public HttpHeaders testHttpHeaders(){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("names","Andy");
        httpHeaders.add("names","Cindy");
        httpHeaders.add("names","Dodge");
        return httpHeaders;
    }
}
