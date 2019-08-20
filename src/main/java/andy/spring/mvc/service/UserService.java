package andy.spring.mvc.service;

import andy.spring.mvc.model.UserForm;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;

/**
 * @author ZhangGuohua
 */
@Validated
@Service
public class UserService {

    /**
     * 该方法用于演示 Service 方法层面的参数验证:
     * 1. 是使用 Java Bean Validation ， 还是使用 防御性编程，在方法内部使用代码检查参数 ?
     * 参考文章 :  https://stackoverflow.com/questions/11929781/check-preconditions-in-controller-or-service-layer
     * 2. 如何使用 Spring Validation 方法级别验证 : https://www.cnblogs.com/beiyan/p/5946345.html,
     * 这并不是 JSR303 和 Hibernate 标准或者实现，而是 Spring 自己的功能扩展
     *
     * @param userForm
     * @param comments
     * @return
     */
    public long addUser(@Valid UserForm userForm, @Size(min = 6, max = 255) String comments) {
        //TBD
        return 1L;
    }
}
