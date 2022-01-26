package andy.zero;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NCFlinkCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        StreamingJob.main(args);
    }
}
