package andy.tut.springboot.zero.controller;

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
public class WeatherController {

    /**
     * 演示基于 freemarker 模板技术的 html 页面
     * @param model
     * @return
     */
    @RequestMapping("/weather")
    public String weatherHtmlByFreemarker(Model model) {
        model.addAttribute("today", LocalDate.now().toString());
        int max = new Random().nextInt(100);
        model.addAttribute("max", "" + max);
        int min = max - new Random().nextInt(30);
        model.addAttribute("min", "" + min);
        return "weather";
    }

    /**
     * 演示返回 json body
     * @param model
     * @return
     */
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

    /**
     * 演示返回 xml body
     * @param model
     * @return
     */
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
}
