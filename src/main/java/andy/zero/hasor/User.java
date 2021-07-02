package andy.zero.hasor;

import lombok.Data;

@Data
public class User {
    int id;
    String name;
    int age;
    char sex;

    public User() {
    }

    public User(int id, String name, int age, char sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
