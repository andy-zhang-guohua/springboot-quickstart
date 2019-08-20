package andy.spring.mvc.controller;

import andy.spring.mvc.model.UserForm;
import andy.spring.mvc.service.UserService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * 此类主要用于验证 Validator 的效果
 * 只要引入了包 spring-boot-starter-web , 它隐含引入 hibernate-validator
 *
 * @author ZhangGuohua
 * @date 2019/7/19
 */
@Slf4j
@RestController
/**
 * 注意：如果要在方法上验证非基本数据类型参数，必须要在类级别使用注解  @Validated
 */
@Validated
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 演示 Validator 作用和效果
     * 验证通过测试URL : http://localhost:8080/user/new?username=andy&password=111&phone=18612936139&age=30&comments=test
     * 验证失败测试URL : http://localhost:8080/user/new?username=andy&password=111&phone=18612936139&age=3
     * <p>
     * FAQ :
     * 1. Q: 参数中没有 BindingResult bindingResult 时验证失败时候会出现 Whitelabel Error Page 而不是返回 JSON，为什么 ? -- 2019-07-18
     * A: ModelAttributeMethodProcessor 中专门对此做了处理。它会检测控制器方法中是否带有此参数，如果有，验证出错时会将结果放到该
     * 参数中但是不抛出异常，如果没有此参数，则会抛出异常 BindException
     *
     * @return 返回一个 JSON 字符串
     */
    @RequestMapping(value = "/user/new", produces = {"application/json; charset=UTF-8"})
    public Object newUser(
            // 注意这里的注解  @Valid, 如果不使用该注解，则这里不会对该参数对象属性做验证,
            // 该参数不需要类级别有注解 @Validated
            @Valid UserForm userForm,
            // 这里可以是一个JSR-303 验证注解,或者某个 Validation Provider 自己提供的注解
            // 该参数需要类级别有注解 @Validated
            @Size(min = 4, max = 255)
            @RequestParam(value = "comments") String comments,
            BindingResult bindingResult, Model model) {
        log.info("comments:{}", comments);
        log.info("userForm:{}", userForm);
        log.info("bindingResult:{}", bindingResult);

        userService.addUser(userForm, comments);

        return new Gson().toJson(model);
    }


}
