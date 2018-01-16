package andy.tut.springboot.zero.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Random;

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

    @RequestMapping("/weather")
    String weather(Model model) {
        model.addAttribute("today", LocalDate.now().toString());
        int max = new Random().nextInt(100);
        model.addAttribute("max", "" + max);
        int min = max - new Random().nextInt(30);
        model.addAttribute("min", "" + min);
        return "weather";
    }
}
