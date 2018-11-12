package andy.zero;

import andy.zero.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class JPASpecificationTest {
    @Autowired
    StudentService studentService;

    /**
     * 前提 : 空表，增加学生信息和班级信息
     */
    @Test
    public void testAddStudentsAndClasses() {

    }


}
