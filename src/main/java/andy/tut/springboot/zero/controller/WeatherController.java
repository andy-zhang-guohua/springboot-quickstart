package andy.tut.springboot.zero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author ZhangGuohua
 * @date 2017/10/29
 */
@Controller
public class WeatherController {
    /**
     * 演示基于 freemarker 模板技术的 html 页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/weather")
    public String weatherHtmlByFreemarker(Model model) {
        model.addAttribute("today", LocalDateTime.now().toString());
        int max = new Random().nextInt(100);
        model.addAttribute("max", "" + max);
        int min = max - new Random().nextInt(30);
        model.addAttribute("min", "" + min);
        return "weather";
    }

    @RequestMapping("/weather/forward")
    public String weatherHtmlByFreemarkerForward(Model model) {
        model.addAttribute("today", LocalDateTime.now().toString());
        int max = new Random().nextInt(100);
        model.addAttribute("max", "" + max);
        int min = max - new Random().nextInt(30);
        model.addAttribute("min", "" + min);
        return "forward:/weather";
    }

    /**
     * 此方法用于当前控制器类中所有控制器方法的数据模型中添加一个属性 comments
     * @return
     */
    @ModelAttribute(name="comments")
    public String customModelAttributeComments() {
        return "my customer model attribute comments , generated at " + LocalDateTime.now();
    }

    /**
     * 此方法用于当前控制器类中所有控制器方法的数据模型中添加一个属性 remarks
     * @return
     */
    @ModelAttribute(name="remarks")
    public String customModelAttributeRemarks() {
        return "my customer model attribute remarks , generated at " + LocalDateTime.now();
    }

    /**
     * 演示返回 json body
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/weather/json", produces = {"application/json; charset=UTF-8"})
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

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

    }

    /**
     * 演示返回 xml body
     *
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
