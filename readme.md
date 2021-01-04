# 2021-01-04

- 试用 flowable 结合 Spring Boot 的应用
    - [参考文档](https://www.cnblogs.com/chengxy-nds/p/13576330.html)
    - [Flowable项目源代码官方网址](https://github.com/flowable/flowable-engine)
    
- 试用场景1
    - 引入基本的 flowable 依赖，
    - 创建 MySQL 数据库 flowable 空库
    - 启动应用，让 flowable 完成数据库初始化
    - 遇到的问题
        - Q01 : MySQL 版本是8，初始化创建表时遇到错误 :  
        `java.sql.SQLSyntaxErrorException: Table 'flowable-spring-boot.act_id_user' doesn't exist`
            - [解决方案](https://blog.csdn.net/qq_41720208/article/details/102172112)
            - 在 MySQL 连接字符串中增加 `&nullCatalogMeansCurrent=true`
