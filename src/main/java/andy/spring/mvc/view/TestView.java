package andy.spring.mvc.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author ZhangGuohua
 * @date 2019-08-20
 */
public class TestView  implements View {
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
