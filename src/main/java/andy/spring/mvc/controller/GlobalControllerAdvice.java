package andy.spring.mvc.controller;

import andy.spring.mvc.exceptions.AndyTestException;
import andy.spring.mvc.view.ExceptionHandlerView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.View;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 该类是一个全局 @ControllerAdvice 类，用于给 basePackages 下的所有控制器类提供统一的 ：
 * 1. @ExceptionHandler 机制
 * 2. @InitBinder 机制
 * 3. @ModelAttribute 机制
 * 参考文章 : https://blog.csdn.net/zxfryp909012366/article/details/82955259
 *
 * @author ZhangGuohua
 * @date 2019-08-20
 */
@Slf4j
@ControllerAdvice(basePackages = "andy.tut.springweb")
public class GlobalControllerAdvice {
    /**
     * 此方法定义一个异常处理器，仅仅处理异常 AndyTestException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AndyTestException.class)
    public View handleAndyTestException(AndyTestException e) {
        e.printStackTrace();
        return new ExceptionHandlerView(e);
    }

    /**
     * 此 @InitBinder 方法会影响到引用中所有的控制器类
     *
     * @param binder
     */
    @InitBinder
    public void globalInitBinder(WebDataBinder binder) {
        // addCustomFormatter 内部自己推断类型并最终调用 registerCustomEditor
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));

        // 以下代码参考 : https://www.jianshu.com/p/b52db905f020
        binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            }
        });
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
            }
        });
        binder.registerCustomEditor(LocalTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                setValue(LocalTime.parse(text, DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
        });
    }

    /**
     * 此 @ModelAttribute 方法会影响到引用中所有的控制器类
     *
     * @return
     */
    @ModelAttribute(value = "time-message")
    public String globalModelAttributeTimeMessage() {
        return "this is is a message created at time " + LocalDateTime.now().toString();
    }
}
