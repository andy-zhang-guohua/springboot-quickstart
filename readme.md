# 学习/演示基于JPA的一些知识点

* 项目特点 :
    * 单数据源
    * Hibernate
    * JPA
    * MySQL

* 学习/演示知识点 :
    * JPA 动态查询
        * 模糊查询 (like)
        * WHERE条件动态构造
    * JPA 多表联合查询
        * JOIN
        * 返回结果到Java Model的转换
    * @EntityScan
        * 可多处使用，basePackages可重叠，并集要能覆盖所有需要的entity
    * @EnableJpaRepositories
        * 可多处使用，basePackages不可重叠，并集要能覆盖所有需要的repository