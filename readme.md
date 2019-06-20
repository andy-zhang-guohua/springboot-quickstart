# 学习/演示基于JPA的一些知识点

* 项目特点 :
    * 单数据源
    * Hibernate
    * JPA
    * MySQL

* 主要学习/演示知识点 :
    * 所使用实体
        * `Grade` 班级
        * `Student` 学生
        * 每个学生在学生表中有一条记录
        * 每个学生只属于某一个班级
        * 班级和学生实体`JPA`层面之间没有定义关系，但实际上学生实体的班级id指向该学生所属班级实体

    * `StudentService`
        * 基于 JpaRepository + JpaSpecificationExecutor 的查询
        * 联合没有`JPA`关系定义的`Grade`,`Student`进行查询，只返回返回`Student`;

    * EntityManagerQueryTest
        * 基于 EntityManager/JPQL 的查询
        * 单表，多表查询

        * JOIN
        * 返回结果到Java Model的转换
    * @EntityScan
        * 可多处使用，basePackages可重叠，并集要能覆盖所有需要的entity
    * @EnableJpaRepositories
        * 可多处使用，basePackages不可重叠，并集要能覆盖所有需要的repository
        
* 其他学习知识点
    * JSR-303 注解 + Spring @Validated       