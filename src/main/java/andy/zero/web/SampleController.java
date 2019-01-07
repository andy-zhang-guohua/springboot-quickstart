package andy.zero.web;

import andy.zero.service.EmployeeService;
import andy.zero.service.GradeService;
import andy.zero.service.StudentService;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.boot.web.servlet.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.interceptor.AbstractFallbackTransactionAttributeSource;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangGuohua on 2017/10/29.
 */
@Controller
public class SampleController {

    AnnotationAwareAspectJAutoProxyCreator a;
    OrderedFormContentFilter aaa;
    AnnotationTransactionAttributeSource annotationTransactionAttributeSource;
    BeanFactoryTransactionAttributeSourceAdvisor bf;
    ProxyTransactionManagementConfiguration p;

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
