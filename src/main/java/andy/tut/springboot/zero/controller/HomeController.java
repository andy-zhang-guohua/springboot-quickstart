package andy.tut.springboot.zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.*;

import javax.servlet.ServletRequest;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@Controller
public class HomeController {

    @Value("${city}")
    String city;

    RequestParamMethodArgumentResolver requestParamMethodArgumentResolver;
    RequestParamMapMethodArgumentResolver requestParamMapMethodArgumentResolver;
    PathVariableMethodArgumentResolver pathVariableMethodArgumentResolver;
    MatrixVariableMethodArgumentResolver matrixVariableMethodArgumentResolver;
    ServletModelAttributeMethodProcessor servletModelAttributeMethodProcessor;
    RequestResponseBodyMethodProcessor requestResponseBodyMethodProcessor;
    RequestPartMethodArgumentResolver requestPartMethodArgumentResolver;
    RequestHeaderMethodArgumentResolver requestHeaderMethodArgumentResolver;
    ServletCookieValueMethodArgumentResolver servletCookieValueMethodArgumentResolver;
    ExpressionValueMethodArgumentResolver expressionValueMethodArgumentResolver;
    SessionAttributeMethodArgumentResolver sessionAttributeMethodArgumentResolver;
    RequestAttributeMethodArgumentResolver requestAttributeMethodArgumentResolver;
    ServletRequestMethodArgumentResolver servletRequestMethodArgumentResolver;
    ServletResponseMethodArgumentResolver servletResponseMethodArgumentResolver;
    HttpEntityMethodProcessor httpEntityMethodProcessor;
    RedirectAttributesMethodArgumentResolver redirectAttributesMethodArgumentResolver;
    ModelMethodProcessor modelMethodProcessor;
    MapMethodProcessor mapMethodProcessor;
    ErrorsMethodArgumentResolver errorsMethodArgumentResolver;
    SessionStatusMethodArgumentResolver sessionStatusMethodArgumentResolver;
    UriComponentsBuilderMethodArgumentResolver uriComponentsBuilderMethodArgumentResolver;
    RequestMappingHandlerAdapter requestMappingHandlerAdapter;

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

    @RequestMapping(value="/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map home(@RequestParam int name) {
        Map map=new TreeMap();
        map.put("message","Hello " + name);
         return map;
    }

    @RequestMapping(value="/{name}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map userHome(@PathVariable String name) {
        Map map=new TreeMap();
        map.put("message","Hello are you " + name + "?");
        return map;
    }
}
