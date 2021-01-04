package andy.bpmn.flowable.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class TestService {
    public void run() {
        log.info("Hello, 现在是 : {}", LocalDateTime.now());
    }
}
