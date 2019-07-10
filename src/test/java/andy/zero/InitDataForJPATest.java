package andy.zero;

import andy.zero.service.GradeService;
import andy.zero.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

/**
 * 本工具用于初始化测试数据
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class InitDataForJPATest {
    @Autowired
    public void setStudentService(StudentService s) {
        this.studentService = s;
    }

    StudentService studentService;

    @Autowired
    public void setGradeService(GradeService s) {
        this.gradeService = s;
    }

    GradeService gradeService;

    /**
     * 前提 : 空表，
     * 增加学生信息和班级信息
     */
    @Test
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
}
