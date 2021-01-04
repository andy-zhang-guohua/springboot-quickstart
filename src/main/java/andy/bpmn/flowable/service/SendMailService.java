package andy.bpmn.flowable.service;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendMailService implements JavaDelegate {
    @Autowired
    TestService testService;

    public void execute(DelegateExecution execution) {
        log.info("Sending rejection mail to author, 文章被拒绝，processInstanceId = {}", execution.getProcessInstanceId());
        testService.run();
    }
}
