# 项目介绍

- springboot 非 web 项目
- 用于调查springboot 中使用 camunda 执行 BPMN 流程并观察其行为
- 调查点
    - springboot 集成 camunda
    - 运行 camunda modeler 创建的 BPMN 流程
    - 观察流程生命周期事件
    - 观察用户事件生命周期事件
    - 观察自动任务生命周期事件
    - 观察流程，节点变量

-  问题
    1. 如何在 output 中引用 input 定义的变量 ?
    举例如下 : 
    ```xml
    <camunda:inputOutput>
        <camunda:inputParameter name="x">foo</camunda:inputParameter>
        <camunda:inputParameter name="willBeNull"/>
        <camunda:outputParameter name="y">${x}</camunda:outputParameter>
        <camunda:outputParameter name="z">${willBeNull == null}</camunda:outputParameter>
    </camunda:inputOutput>
    ```
    2. 是否可以自动 claim 用户任务 ?
        - 如果用户任务指定了 assignee, 则不需要 claim;
        - 如果用户任务没有指定 assignee, 则需要 claim;
    3. 如果一个流程任务返回重复执行多次，是否可以在任务实例历史图中体现这一点 ?
    4. 流程变量都可以使用哪些环境元素或者变量 ?
    5. 如何控制一个流程的启动权限 ?
    6. Camunda 中, BPMN 一个节点可以有两个输入连线；而AWS PaaS 中不可以；这是 Camunda 的对BPMN的扩展？
    7. Camunda Tasklist 中,流程变量在某些节点是否可以禁止修改 ?
    8. 如何将流程第一个节点的办理人设置成流程启动者 ?
        - 流程定义时将第一个节点的办理人 assignee 设置成 `${authenticatedUserId}` 或者 `${currentUser()}`
    9. 变量只能在节点内定义,不能在流程定义时定义 ?
        - 参考官方资料 `Process Variables`       
    10. 是否可以设置流程标题 ?    

- 参考资料 
    - [如何实现Springboot+camunda+mysql的集成](https://www.cnblogs.com/hibpm/p/14926354.html)
    - 云程系统开发者文章
        - [Camunda流程引擎快速入门——Hello World示例](https://lowcode.blog.csdn.net/article/details/117518828)
        - [Camunda如何配置和使用mysql数据库](https://lowcode.blog.csdn.net/article/details/117564836) 
        - [基于camunda如何实现会签：camunda会签流程配置与原理解析](https://blog.csdn.net/wxz258/article/details/118055189)
    - 官方资料
        - [Expression Language](https://docs.camunda.org/manual/7.4/user-guide/process-engine/expression-language/)        
        - [Process Variables](https://docs.camunda.org/manual/7.4/user-guide/process-engine/variables/)               
    