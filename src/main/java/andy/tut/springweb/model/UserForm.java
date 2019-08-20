package andy.tut.springweb.model;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 新增用户，或者修改用户表单
 *
 * @author ZhangGuohua
 */
@Data
public class UserForm {
    @NotBlank(message ="用户名不能为空")
    String username;

    @NotBlank(message ="密码不能为空")
    String password;

    @Min(18)
    private Integer age;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    @Email(message = "邮箱格式错误")
    private String email;
}
