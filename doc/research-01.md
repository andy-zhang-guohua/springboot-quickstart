# 观察流程生命周期事件

实施步骤如下 :
1. 新建类
    - `com.andy.camunda.listeners.DefaultExecutionListener` 实现接口 `ExecutionListener`
        - 用于观察执行`Execution`生命周期事件    
        - 用于观察执行`Process`生命周期事件
        - 用于观察执行连线生命周期事件
    - `com.andy.camunda.listeners.DefaultTaskListener` 实现接口 `TaskListener`
        - 用于观察任务`Task`生命周期事件
        
2. 为 `vacation_2.bpmn` 流程两节点添加 `Task Listener`
    - `create : Java Class`
    - `assignment : Java Class`
    - `complete : Java Class`
    - `delete : Java Class`
    - `update : Java Class`
    - `timeout : Java Class` -- 注意这个先不设置

3. 为 `vacation_2.bpmn` `Execution Listener`
    3.1 为 `vacation_2.bpmn` 流程 `Execution Listener`
        - `start : Java Class`
        - `end : Java Class`
    3.2 为 `vacation_2.bpmn` 流程两节点添加 `Execution Listener`
        - `start : Java Class`
        - `end : Java Class`
    3.3 为 `vacation_2.bpmn` 流程中各个连线添加 `Execution Listener`
        - `take : Java Class`
    
4. 运行一个`vacation_2.bpmn`流程实例


#参考资料
 - [Camunda BPMN - Task listener vs Execution listeners](https://stackoverflow.com/questions/29506960/camunda-bpmn-task-listener-vs-execution-listeners)
 - [Delegation Code](https://docs.camunda.org/manual/7.4/user-guide/process-engine/delegation-code/)