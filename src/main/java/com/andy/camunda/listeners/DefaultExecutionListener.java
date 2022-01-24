package com.andy.camunda.listeners;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

@Slf4j
public class DefaultExecutionListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) {
        String processDefId = execution.getProcessDefinitionId();
        String processInstId = execution.getProcessInstanceId();
        String executionId = execution.getId();

        log.info("正在执行事件 ： {} -- {} ==> {}", processDefId, processInstId, executionId);
    }
}