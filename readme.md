# 2021-04-05
- 事件监听器
    - [参考资料](https://flowable.com/open-source/docs/bpmn/ch03-Configuration/#event-handlers)
    - 实现方式  
        - 实现接口 `org.flowable.engine.delegate.event.FlowableEventListener`
        - 或者继承基础类 `org.flowable.engine.delegate.event.BaseEntityEventListener`
    - 一个事件监听器可以监听哪些事件
        - 可以针对所有事件进行监听
        - 也可以针对指定的某些事件进行监听     
    - 事件监听器的配置方法
        - 引擎运行前配置到`ProcessEngineConfiguration`组件上
        - 引擎运行时添加事件监听器`RuntimeService.addEventListener`
            - 引擎一旦重启，这种方式添加的事件监听器会消失
        - 添加到流程定义上
            - 仅在该流程定义对应的流程实例中起作用
              

# 2021-01-04

- 试用 flowable 结合 Spring Boot 的应用
    - [参考文档](https://www.cnblogs.com/chengxy-nds/p/13576330.html)
        - 请假流程参考文档
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
- 试用场景3 ： [另外一个流程,含有自动化 ServiceTask](https://www.baeldung.com/flowable)
    - 文章提交和批准/驳回
    - 通过流程定义可以定义 `ServiceTask` 和对应的实现类
    - 相应的 `ServiceTask` 实现类必须要实现 `JavaDelegate`
    - 相应的 `ServiceTask` `JavaDelegate` 实现逻辑 `execute(DelegateExecution execution)` 会在流程指定时机被自动调用
    - 如果 `JavaDelegate` 实现类里面要使用 `@Autowired` 注入其他 `bean`，则必须
        - 1. 在流程定义中使用 `flowable:delegateExpression="${sendMailService}"` 方式引用 `bean`;
        - 2. `JavaDelegate` 实现类一定要使用 `@Component/@Service` 之类的注解。