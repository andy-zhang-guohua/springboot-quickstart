package andy.zero.repo;

import andy.zero.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    /**
     * 找到所有姓名包含 pattern 的学生
     * 如果不指定SQL的话，方法名称一定要使用 JPA 规定的形式 findBy+参数名+Like(参数)
     *
     * @param pattern
     * @return
     */
    List<Student> findByNameLike(String pattern);
}
