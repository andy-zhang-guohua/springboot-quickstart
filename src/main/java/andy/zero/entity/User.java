package andy.zero.entity;

import andy.zero.enums.Gender;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("user")
public class User {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    String id;
    Gender gender;
    String name;
    Integer age;
    String email;
}
