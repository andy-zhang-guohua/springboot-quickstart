package andy.zero;

import andy.zero.entity.Grade;
import andy.zero.entity.Student;
import andy.zero.service.GradeService;
import andy.zero.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class JPASpecificationTest {
    @Autowired
    StudentService studentService;

    @Autowired
    GradeService gradeService;

    /**
     * 前提 : 空表，
     * 增加学生信息和班级信息
     */
    //@Test
    public void testAddStudentsAndClasses() {
        long grade1Id = gradeService.add("高一(1)班");
        long grade2Id = gradeService.add("高二(4)班");
        long grade3Id = gradeService.add("高三(5)班");

        studentService.add("李白", "001", true, grade1Id, LocalDate.of(1985, 1, 1));
        studentService.add("杜甫", "002", true, grade1Id, LocalDate.of(1985, 3, 5));
        studentService.add("汪伦", "003", true, grade1Id, LocalDate.of(1985, 8, 9));

        studentService.add("李乐山", "101", true, grade2Id, LocalDate.of(1985, 2, 3));
        studentService.add("王东升", "102", true, grade2Id, LocalDate.of(1985, 5, 28));
        studentService.add("谢云峰", "103", true, grade2Id, LocalDate.of(1985, 7, 14));

        studentService.add("汪鹏程", "201", true, grade3Id, LocalDate.of(1985, 12, 3));
        studentService.add("程素晴", "202", false, grade3Id, LocalDate.of(1985, 6, 28));
        studentService.add("杨国富", "203", true, grade3Id, LocalDate.of(1985, 2, 4));
    }

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
            String pattern = "二";
            List<Student> students = studentService.findAllWithClassNameLike(pattern);
            log.info("班级名称包含\"{}\"的学生:{}", pattern, students);
        }
    }
}
