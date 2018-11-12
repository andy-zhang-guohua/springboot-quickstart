package andy.zero.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private long classId;

    /**
     * 生日
     */
    private LocalDateTime birthday;

    /**
     * 学号
     */
    @Column(unique = true)
    private String studentNo;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(nullable = true)
    private LocalDateTime lastUpdateTime;
}
