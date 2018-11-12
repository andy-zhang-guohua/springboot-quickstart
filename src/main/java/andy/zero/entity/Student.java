package andy.zero.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 学生表
 */
@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别:0-女,1-男
     */
    boolean gender;

    /**
     * 班级id
     */
    private long gradeId;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 学号
     */
    @Column(unique = true)
    private String studentNo;
}
