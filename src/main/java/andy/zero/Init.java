package andy.zero;

import andy.zero.mq.JMSListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Init implements CommandLineRunner {
    @Override
    public void run(String... args) {
        String dest = "DEMO";
        JMSListener.startJmsQueueListener(dest, message -> {
            log.info("message : {}", message);
        });
    }
}
