package andy.zero.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ResponseBody
@RequestMapping("/")
public class HomeController {
    /**
     * 输入http://localhost:8080直接跳转到http://localhost:8080/interface-ui/
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @GetMapping
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/interface-ui/");
    }
}
