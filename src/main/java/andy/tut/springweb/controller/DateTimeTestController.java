package andy.tut.springweb.controller;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ZhangGuohua
 * @date 2019/08/20
 */
@RestController
@RequestMapping(value = "/test/datetime/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DateTimeTestController {
    /**
     * 测试地址 : http://localhost:8080/test/datetime/?date=2019-08-20&localDateTime=2019-08-20T12:30:02
     * 这里日期参数 date, localDateTime 要使用 GlobalControllerAdvice#globalInitBinder 中定义的格式
     * @param model
     * @param date
     * @param localDateTime
     * @return
     */
    @RequestMapping(value = "/")
    public Map defaultTest(Model model, @RequestParam(value = "date") Date date, @RequestParam(value = "localDateTime") LocalDateTime localDateTime) {
        model.addAttribute("date", date);
        model.addAttribute("localDateTime", localDateTime);

        // 注意，这里直接返回 model.asMap() 和直接返回 model 的效果是类似的，返回 TreeMap 可以导致返回JSON数据
        Map map = new TreeMap();
        map.putAll(model.asMap());
        return map;
    }
}
