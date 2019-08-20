package andy.tut.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletRequest;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ZhangGuohua
 * @date 2017/10/29
 */
@Controller
public class HomeController {

    @Value("${city}")
    String city;

    /**
     * 实验自动ServletRequest到控制器单例构造函数参数
     *
     * @param request
     */
    public HomeController(ServletRequest request) {
        constructorRequest = request;
    }

    ServletRequest constructorRequest;

    /**
     * 实验自动ServletRequest到控制器单例对象字段
     * 注意 :
     * 1. ServletRequest 是请求/响应 scope
     * 2. 而当前控制器组件是容器单例
     * 所以需要注意注入为什么可以成功 ?
     */
    @Autowired
    ServletRequest fieldRequest;

    ServletRequest methodRequest;

    /**
     * 实验自动ServletRequest到控制器单例对象方法
     *
     * @param request
     */
    @Autowired
    public void setRequest(ServletRequest request) {
        this.methodRequest = request;
    }

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map home() {
        Map map = new TreeMap();
        map.put("message", "这是首页");
        map.put("now", LocalDateTime.now());
        return map;
    }

    /**
     * 观察特性: @ResponseStatus 的使用，效果 :
     * 1. /hello/abc ==> 400 错误，参数 name 类型不匹配
     * 2. /hello/1 ==> Whitelabel Error Page, 500 错误， 错误原因 : test
     *
     * @param name
     * @return
     */
    @ResponseStatus(reason = "test")
    @RequestMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map helloName(@PathVariable int name) {
        Map map = new TreeMap();
        map.put("message", "Hello, are you " + name + "?");
        return map;
    }


}
