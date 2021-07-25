package andy.zero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SystemInitService implements CommandLineRunner {
    @Autowired
    TestService testService;

    @Override
    public void run(String... args) throws Exception {
        testService.testDataQL();
        //testService.testUDF();
        //testService.testExecuteSQL();
    }
}
