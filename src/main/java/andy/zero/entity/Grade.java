package andy.zero.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 班级表
 */
@Entity
@Table(name = "grade")
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    /**
     * 班级名称
     */
    private String name;
}
