package andy.tut.springboot.zero.controller;

import andy.tut.springboot.zero.model.UserForm;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ZhangGuohua
 */
@RestController
public class UserController {
    /**
     * 演示 Validator 作用和效果
     *
     * @return
     */
    @RequestMapping(value ="/user/new", produces = {"application/json; charset=UTF-8"})
    public Object newUser(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
        model.addAttribute("userForm",userForm);
        model.addAttribute("bindingResult",bindingResult);
        return model;
    }


}
