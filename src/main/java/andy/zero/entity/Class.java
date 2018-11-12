package andy.zero.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 班级表
 */
@Entity
@Table(name = "class")
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    /**
     * 班级名称
     */
    private String name;


    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(nullable = true)
    private LocalDateTime lastUpdateTime;
}
