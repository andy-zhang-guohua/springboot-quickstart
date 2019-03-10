package andy.tut.springboot.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@Controller
public class HomeController {

    @Value("${city}")
    String city;

    public HomeController(ServletRequest request) {
        constructorRequest = request;
    }

    ServletRequest constructorRequest;

    @Autowired
    ServletRequest fieldRequest;

    ServletRequest methodRequest;

    @Autowired
    public void setRequest(ServletRequest request) {
        this.methodRequest = request;
    }

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello " + methodRequest.getParameter("name");
    }
}
