package andy.tut.springboot.zero.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@Controller
public class SampleController {
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }


    @RequestMapping("/weather/json")
    @ResponseBody
    public Map weatherJSON(Model model) {
        model.addAttribute("today", LocalDate.now().toString());
        int max = new Random().nextInt(100);
        model.addAttribute("max", "" + max);
        int min = max - new Random().nextInt(30);
        model.addAttribute("min", "" + min);
        Map result = new TreeMap();
        result.putAll(model.asMap());
        return result;
    }

    @RequestMapping(value = "/weather/xml", produces = {"application/xml; charset=UTF-8"})
    @ResponseBody
    public Map weatherXML(Model model) {
        model.addAttribute("today", LocalDate.now().toString());
        int max = new Random().nextInt(100);
        model.addAttribute("max", "" + max);
        int min = max - new Random().nextInt(30);
        model.addAttribute("min", "" + min);
        Map result = new TreeMap();
        result.putAll(model.asMap());
        return result;
    }

    @RequestMapping("/weather")
    public String weather(Model model) {
        model.addAttribute("today", LocalDate.now().toString());
        int max = new Random().nextInt(100);
        model.addAttribute("max", "" + max);
        int min = max - new Random().nextInt(30);
        model.addAttribute("min", "" + min);
        return "weather";
    }
}
