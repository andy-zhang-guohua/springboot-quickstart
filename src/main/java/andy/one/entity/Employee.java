package andy.one.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 员工表
 */
@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    /**
     * 员工姓名
     */
    private String name;
}
