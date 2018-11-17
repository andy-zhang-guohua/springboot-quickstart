package andy.zero;

import andy.zero.entity.Grade;
import andy.zero.entity.Student;
import andy.zero.service.GradeServiceImpl;
import andy.zero.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RandomValuePropertySourceTest {
    @Autowired
    Environment environment;


    @Test
    public void testRandomValuePropertySource() {
        RandomValuePropertySource random = new RandomValuePropertySource("random");
        log.info("random int:{}",random.getProperty("random.int"));

        log.info("random long:{}",random.getProperty("random.long"));

        log.info("random uuid:{}",random.getProperty("random.uuid"));

        log.info("environment random uuid:{}",environment.getProperty("random.uuid"));
    }
}
