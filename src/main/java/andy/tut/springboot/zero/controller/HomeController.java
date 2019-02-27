package andy.tut.springboot.zero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
}
