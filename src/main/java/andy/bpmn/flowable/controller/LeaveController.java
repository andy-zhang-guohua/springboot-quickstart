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
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Qualifier("processEngine")
    @Autowired
    private ProcessEngine processEngine;

    /**
     * @description 启动流程
     */
    @RequestMapping(value = "start", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String startLeaveProcess(String staffId) {
        // 创建新的请假流程
        HashMap<String, Object> map = new HashMap<>();
        map.put("leaveTask", staffId);
        String processDefinitionKey = "Leave";
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, map);


        // 输出新建的请假流程，和当前员工所有的请假历史记录
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
        int length = 0;
        try {
            out = httpServletResponse.getOutputStream();
            while ((length = in.read(buf)) != -1) {
                out.write(buf, 0, length);
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

    /**
     * @description 获取用户请假列表
     */
    @RequestMapping(value = "leave-history", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String leaveHistory(String staffId) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(staffId).orderByTaskCreateTime().desc().list();

        StringBuilder sb = new StringBuilder();
        sb.append("<h2>" + staffId + "的请假记录</h2>");
        sb.append("<table  border=\"1\">");
        sb.append("<thead>");
        sb.append("<tr>");
        sb.append("<th>ID</th>");
        sb.append("<th>CreateTime</th>");
        sb.append("<th>processId</th>");
        sb.append("</tr>");
        sb.append("</thead>");
        sb.append("</tbody>");
        for (Task task : tasks) {
            sb.append("<tr>");
            sb.append("<td>" + task.getId() + "</td>");
            sb.append("<td>" + task.getCreateTime() + "</td>");
            sb.append("<td>" + task.getProcessInstanceId() + "</td>");
            sb.append("</tr>");
        }
        sb.append("</tbody>");
        sb.append("</table>");
        return sb.toString();
    }
}
