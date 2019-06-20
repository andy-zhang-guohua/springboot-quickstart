package andy.zero.service;

import andy.zero.entity.Grade;
import andy.zero.entity.Student;
import andy.zero.repo.StudentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Validated
@Service
public class StudentService {
    @Autowired
    StudentRepository repo;

    @Transactional
    public long add(@NotNull String name, String studentNo, boolean gender, long classId, LocalDate birthday) {
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

    /**
     * 找到班级名称符合某种条件的班级的所有学生
     * <p>
     * 虽然使用了班级属性进行过滤，但是最终是为了过滤和返回学生实体信息
     *
     * @param pattern 如果为 null 或者 "" 表示不进行班级名称过滤
     * @return
     */
    public List<Student> findAllWithGradeNameLike(@Param("pattern") String pattern) {
        Specification<Student> spec = new Specification() {
            @Override
            public Predicate toPredicate(Root rootStudent, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final Root rootGrade = criteriaQuery.from(Grade.class);
                // 两个表联合起来的关联条件
                Predicate predicateJoinFilter = criteriaBuilder.equal(rootStudent.get("gradeId"), rootGrade.get("id"));
                if (StringUtils.isBlank(pattern))
                    return predicateJoinFilter;


                // 在 班级表上过滤班级名称
                Predicate predicateNameFilter = criteriaBuilder.like(rootGrade.get("name"), "%" + pattern + "%");
                //将两个查询条件联合起来之后返回一个Predicate对象
                return criteriaBuilder.and(predicateNameFilter, predicateJoinFilter);
            }
        };

        return repo.findAll(spec);
    }
}
