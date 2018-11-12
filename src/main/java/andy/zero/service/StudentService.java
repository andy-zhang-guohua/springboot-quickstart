package andy.zero.service;

import andy.zero.entity.Grade;
import andy.zero.entity.Student;
import andy.zero.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repo;

    public long add(String name, String studentNo, boolean gender, long classId, LocalDate birthday) {
        Student entity = new Student();
        entity.setName(name);
        entity.setGender(gender);
        entity.setBirthday(birthday);
        entity.setStudentNo(studentNo);
        entity.setGradeId(classId);//建立学生和班级的关系
        repo.save(entity);

        long id = entity.getId();
        if (id <= 0)
            throw new RuntimeException("添加学生失败");

        return id;
    }

    public List<Student> findByNameLike(String pattern) {
        return repo.findByNameLike("%" + pattern + "%");
    }

    public List<Student> findAllWithClassNameLike(@Param("pattern") String pattern) {
        Specification<Student> spec = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Root gradeRoot = criteriaQuery.from(Grade.class);
                // 在 班级表上过滤班级名称
                Predicate predicateNameFilter = criteriaBuilder.like(gradeRoot.get("name"), "%" + pattern + "%");
                // 两个表联合起来的关联条件
                Predicate predicateJoinFilter = criteriaBuilder.equal(root.get("gradeId"), gradeRoot.get("id"));
                //将两个查询条件联合起来之后返回一个Predicate对象
                return criteriaBuilder.and(predicateNameFilter, predicateJoinFilter);
            }
        };

        return repo.findAll(spec);
    }
}