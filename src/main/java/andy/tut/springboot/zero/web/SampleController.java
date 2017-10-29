package andy.tut.springboot.zero.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@Controller
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
