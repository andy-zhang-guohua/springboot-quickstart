package andy.zero;

import andy.zero.entity.Grade;
import andy.zero.entity.Student;
import andy.zero.service.GradeServiceImpl;
import andy.zero.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class JPASpecificationTest {
    @Autowired
    StudentService studentService;

    @Autowired
    GradeServiceImpl gradeService;

    @Test
    public void testQuery() {
        {
            String pattern = "李";
            List<Student> students = studentService.findByNameLike(pattern);
            log.info("姓名包含\"{}\"的学生:{}", pattern, students);
        }

        {
            String pattern = "高";
            List<Grade> grades = gradeService.findByNameLike(pattern);
            log.info("名称包含\"{}\"的班级:{}", pattern, grades);
        }

        {
            // 找到班级名称符合特定条件的班级的所有学生
            String pattern = "二";
            List<Student> students = studentService.findAllWithGradeNameLike(pattern);
            log.info("班级名称包含\"{}\"的学生:{}", pattern, students);
        }

        {
            // 找到所有的学生，因为给定的班级名称过滤器为空
            String pattern = "";
            List<Student> students = studentService.findAllWithGradeNameLike(pattern);
            log.info("班级名称包含\"{}\"的学生:{}", pattern, students);
        }
    }
}
