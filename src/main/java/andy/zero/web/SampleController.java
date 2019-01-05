package andy.zero.web;

import andy.zero.service.EmployeeService;
import andy.zero.service.GradeService;
import andy.zero.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.interceptor.AbstractFallbackTransactionAttributeSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@Controller
public class SampleController {

    AnnotationTransactionAttributeSource annotationTransactionAttributeSource;

    @Autowired
    GradeService gradeService;

    @Autowired
    StudentService studentService;

    @Autowired
    EmployeeService employeeService;


    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
