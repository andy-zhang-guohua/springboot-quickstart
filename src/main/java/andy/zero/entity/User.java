package andy.zero.entity;

import andy.zero.enums.Gender;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    Long id;
    Gender gender;
    String name;
    Integer age;
    String email;
}
