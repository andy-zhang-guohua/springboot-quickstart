package andy.tut.springboot.zero.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * 此Web Controller 配合 ControllerBeanConfig 演示 BeanNameUrlHandlerMapping + SimpleControllerHandlerAdapter 如何工作
 *
 * @author ZhangGuohua
 * @date 2019/02/17
 */
public class WelcomeController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)   {
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("now", LocalDateTime.now().toString());
        String name = request.getParameter("name");
        mav.addObject("name", name == null ? "你是?" : name);
        return mav;
    }
}
