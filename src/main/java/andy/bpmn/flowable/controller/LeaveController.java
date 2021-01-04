package andy.bpmn.flowable.controller;

import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.*;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.task.Event;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/leave")
public class LeaveController {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ProcessEngine processEngine;

    /**
     * @description 启动流程
     */
    @RequestMapping(value = "start", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String startLeaveProcess(String staffId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("leaveTask", staffId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Leave", map);
        StringBuilder sb = new StringBuilder();
        sb.append("创建请假流程 processId : " + processInstance.getId() + "<br/>");
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(staffId).orderByTaskCreateTime().desc().list();
        for (Task task : tasks) {
            sb.append("任务创建时间 : " + task.getCreateTime() + " , ");
            sb.append("assignee : " + task.getAssignee() + " , ");
            sb.append("processId : " + task.getProcessInstanceId() + " , ");
            sb.append("taskId : " + task.getId() + "<br/>");
        }
        return sb.toString();
    }

    /**
     * @param taskId
     * @description 经理批准休假
     */
    @RequestMapping(value = "apply-task", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String applyTask(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            return "流程不存在,可能已经被驳回或者批准 : taskId = " + taskId;
        }

        log.info("任务:{}", task);

        List<Event> events = taskService.getTaskEvents(taskId);
        log.info("任务[{}]事件:{}", taskId, events);

        HashMap<String, Object> map = new HashMap<>();
        map.put("checkResult", "通过");
        taskService.complete(taskId, map);
        return "休假申请审核通过";
    }

    /**
     * @param taskId
     * @description 经理驳回休假
     */
    @ResponseBody
    @RequestMapping(value = "reject-task", produces = MediaType.TEXT_HTML_VALUE)
    public String rejectTask(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            return "流程不存在,可能已经被驳回或者批准: taskId = " + taskId;
        }

        log.info("任务:{}", task);

        List<Event> events = taskService.getTaskEvents(taskId);
        log.info("任务[{}]事件:{}", taskId, events);

        HashMap<String, Object> map = new HashMap<>();
        map.put("checkResult", "驳回");
        taskService.complete(taskId, map);
        return "休假申请审核被驳回";
    }


    /**
     * @description 生成流程图
     */
    @RequestMapping(value = "get-process-diagram")
    public void getProcessDiagram(HttpServletResponse httpServletResponse, String processId) throws Exception {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();
        if (processInstance == null) {
            return;
        }
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();

        String InstanceId = task.getProcessInstanceId();
        List<Execution> executions = runtimeService
                .createExecutionQuery()
                .processInstanceId(InstanceId)
                .list();

        List<String> activityIds = new ArrayList<>();
        List<String> flows = new ArrayList<>();
        for (Execution exe : executions) {
            List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
            activityIds.addAll(ids);
        }

        /**
         * 生成流程图
         */
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        ProcessEngineConfiguration engineConfiguration = processEngine.getProcessEngineConfiguration();
        ProcessDiagramGenerator diagramGenerator = engineConfiguration.getProcessDiagramGenerator();
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "png",
                activityIds, flows, engineConfiguration.getActivityFontName(), engineConfiguration.getLabelFontName(),
                engineConfiguration.getAnnotationFontName(), engineConfiguration.getClassLoader(), 1.0, false);
        OutputStream out = null;
        byte[] buf = new byte[1024];
        int legth = 0;
        try {
            out = httpServletResponse.getOutputStream();
            while ((legth = in.read(buf)) != -1) {
                out.write(buf, 0, legth);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
