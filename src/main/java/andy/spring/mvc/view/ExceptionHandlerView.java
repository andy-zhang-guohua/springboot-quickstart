package andy.spring.mvc.view;

import andy.spring.mvc.exceptions.AndyTestException;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author ZhangGuohua
 * @date 2019-08-20
 */
public class ExceptionHandlerView implements View {
    AndyTestException exception;

    public ExceptionHandlerView(AndyTestException e) {
        exception = e;
    }

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
        builder.append("<html><body><h1>这是一个异常信息展示页面</h1>").append(
                "<p>异常信息如下:</p>")
                .append("<div id='exception'>").append(exception.toString()).append("</div>");
        builder.append("</body></html>");
        response.getWriter().append(builder.toString());
    }


    @Override
    public String getContentType() {
        // 注意这里面的字符集部分，否则浏览器端会看到乱码
        return "text/html;charset=UTF-8";
    }
}
