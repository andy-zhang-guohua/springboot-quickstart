package andy.tut.springboot.zero.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 用于测试各种控制器方法返回值处理器的效果
 *
 * @author ZhangGuohua
 * @date 2019/08/19
 */
@Controller
public class HandlerMethodReturnValueHandlerTestController {

    /**
     * 页面预期效果 : 跳转到根路径
     *
     * 1. 用于观察 HandlerMethodReturnValueHandler 的应用效果
     * 2. 观察此时view name ==> View 的解析过程，以及所使用的 View 对象是什么：是 RedirectView
     * 3. 响应状态字会是 302, 头部 Location 会是类似 http://localhost:8080/ 这样的值
     *
     * @return
     */
    @RequestMapping(value = "/redirect-home")
    public String testUseRedirectPatternViewNameStringAsReturnValueOfHandlerMethod() {
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
     *
     * @return
     */
    @RequestMapping(value = "/http-headers")
    public HttpHeaders testUseHttpHeadersObjectAsReturnValueOfHandlerMethod() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("names", "Andy");
        httpHeaders.add("names", "Cindy");
        httpHeaders.add("names", "Dodge");
        return httpHeaders;
    }

    private static class TestView implements View {

        @Override
        public void render(Map<String, ?> model, HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
            if (response.isCommitted()) {
                return;
            }
            StringBuilder builder = new StringBuilder();
            LocalDateTime now = LocalDateTime.now();
            if (response.getContentType() == null) {
                response.setContentType(getContentType());
            }
            builder.append("<html><body><h1>测试直接返回视图对象</h1>").append(
                    "<p>这是一段测试文字</p>")
                    .append("<div id='created'>").append(now.toString()).append("</div>");
            builder.append("</body></html>");
            response.getWriter().append(builder.toString());
        }


        @Override
        public String getContentType() {
            // 注意这里面的字符集部分，否则浏览器端会看到乱码
            return "text/html;charset=UTF-8";
        }

    }

    @RequestMapping(value = "/view-object")
    public View testUseViewObjectAsReturnValueOfHandlerMethod() {
        return new TestView();
    }
}
