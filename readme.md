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

- 试用场景2 ： 请假流程
    - `controller/LeaveController.java + resources/processes/LeaveProcess.bpmn20.xml`            
    - 休假申请 : `http://localhost:8080/leave/start?staffId=002`
        - 目标调用者 :    休假申请人，员工
        - 页面参数 : 休假申请员工的员工号, staffId 
        - 需要记录结果中的任务ID : taskId, 下面经理驳回/批准要用
        - 结果中会展示所创建流程实例的ID : processId, 每次调用生成新的流程实例，可以记录，生成流程图片接口需要改参数
    - 经理驳回 : `http://localhost:8080/leave/reject-task?taskId=3b28059a-4e2f-11eb-9bba-7cb59b73e0ba`
        - 目标调用者 : 经理
        - 页面参数 : 休假申请任务的ID, taskId, 可以通过休假申请结果获取
        - 同一任务不能二次调用，第二次调用会报告任务不存在        
    - 经理批准 : `http://localhost:8080/leave/apply-task?taskId=3eaff3e3-4e2f-11eb-9bba-7cb59b73e0ba`
    - 生成流程图片
        - 访问地址 : `http://localhost:8080/leave/get-process-diagram?processId=12e5d1da-4e30-11eb-a90d-7cb59b73e0ba`
        - 页面参数 : processId, 可以通过休假申请结果获取
        - 随着流程中任务的执行，流程会推进，所以每次获取的流程图片会不一样

- 动作 : 升级到 Flowable 6.6.0, 自动创建79个表
- 试用场景3 ： 更多业务语义查询
    - 查看员工所有请假记录和状态   ?? 怎么做呢 ??