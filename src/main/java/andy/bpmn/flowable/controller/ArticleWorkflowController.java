package andy.bpmn.flowable.controller;

import andy.bpmn.flowable.domain.Approval;
import andy.bpmn.flowable.domain.Article;
import andy.bpmn.flowable.service.ArticleWorkflowService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleWorkflowController {
    @Autowired
    private ArticleWorkflowService service;

    @Qualifier("processEngine")
    @Autowired
    private ProcessEngine processEngine;

    /**
     * 访问例子 :
     * http://localhost:8080/submit?url=dummy_path&author=andy&id=001
     *
     * @param article
     */
    @RequestMapping("/submit")
    public String submit(Article article) {
        ProcessInstance processInstance = service.startProcess(article);
        return processInstance.getId();
    }

    /**
     * 访问例子 :
     * http://localhost:8080/tasks
     * http://localhost:8080/tasks?assignee=editors
     * 这里 assignee=editors 来自 article-workflow.bpmn20.xml 中的属性定义 flowable:candidateGroups
     *
     * @param assignee
     * @return
     */
    @GetMapping("/tasks")
    public List<Article> getTasks(@RequestParam(name = "assignee", defaultValue = "editors", required = false) String assignee) {
        return service.getTasks(assignee);
    }

    /**
     * 访问例子 :
     * http://localhost:8080/review?id=1671dabd-4e81-11eb-8ec9-7cb59b73e0ba&status=true
     * 这里 id 是 task 的ID，可以从 /tasks 访问结果中看到
     *
     * @param approval
     */
    @RequestMapping(value = "/review", produces = MediaType.TEXT_HTML_VALUE)
    public String review(Approval approval) {
        try {
            service.submitReview(approval);
            return "审核 id = " + approval.getId() + "的任务成功, status 设置为 :" + approval.isStatus();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    /**
     * http://localhost:8080/history?processId=113eea06-4e83-11eb-9100-7cb59b73e0ba
     *
     * @return
     */
    @GetMapping("/history")
    public List getHistory(@RequestParam(name = "processId") String processId) {
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> activities = historyService
                .createHistoricActivityInstanceQuery()
                .processInstanceId(processId)
                .finished()
                .orderByHistoricActivityInstanceEndTime()
                .asc()
                .list();

        return activities;
    }
}
