package andy.tut.springboot.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Random;

/**
 * @author ZhangGuohua
 */
@RestController
public class UserController {
    @Autowired
    Validator validator;

    /**
     * 演示基于 freemarker 模板技术的 html 页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/new")
    public String newUser(Model model) {
        model.addAttribute("today", LocalDate.now().toString());
        int max = new Random().nextInt(100);
        model.addAttribute("max", "" + max);
        int min = max - new Random().nextInt(30);
        model.addAttribute("min", "" + min);
        return "weather";
    }


}
