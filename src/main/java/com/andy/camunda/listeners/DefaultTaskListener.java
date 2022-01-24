package com.andy.camunda.listeners;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

@Slf4j
public class DefaultTaskListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        String eventName = delegateTask.getEventName();
        String taskDefKey = delegateTask.getTaskDefinitionKey();
        String processDefId = delegateTask.getProcessDefinitionId();
        String processInstId = delegateTask.getProcessInstanceId();
        String executionId = delegateTask.getExecutionId();

        log.info("正在执行事件 ： {} -- {} ==> {} ==> {}-{} ", processDefId, processInstId, executionId, taskDefKey, eventName);
    }
}