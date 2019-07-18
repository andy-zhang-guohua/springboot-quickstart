package andy.tut.springboot.zero.controller;

import andy.tut.springboot.zero.model.UserForm;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 此类主要用于验证 Validator 的效果
 * 只要引入了包 spring-boot-starter-web , 它隐含引入 hibernate-validator
 * @author ZhangGuohua
 */
@Slf4j
@RestController
public class UserController {
    /**
     * 演示 Validator 作用和效果
     * 验证通过测试URL : http://localhost:8080/user/new?username=andy&password=111&phone=18612936139&age=30
     * 验证失败测试URL : http://localhost:8080/user/new?username=andy&password=111&phone=18612936139&age=3
     * <p>
     * FAQ :
     * 1. Q: 参数中没有 BindingResult bindingResult 时验证失败时候会出现 Whitelabel Error Page 而不是返回 JSON，为什么 ? -- 2019-07-18
     * A: ModelAttributeMethodProcessor 中专门对此做了处理。它会检测控制器方法中是否带有此参数，如果有，验证出错时会将结果放到该
     * 参数中但是不抛出异常，如果没有此参数，则会抛出异常 BindException
     * @return 返回一个 JSON 字符串
     */
    @RequestMapping(value = "/user/new", produces = {"application/json; charset=UTF-8"})
    public Object newUser(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
        log.info("userForm={}", userForm);
        log.info("bindingResult={}", bindingResult);
        return new Gson().toJson(model);
    }


}
