package andy.zero.repo;

import andy.zero.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    /**
     * 找到所有姓名包含 pattern 的学生
     *
     * @param pattern
     * @return
     */
    @Query("select e from Student e where e.name like :pattern")
    List<Student> findAllWithNameLike(String pattern);

    /**
     * 找到所有班级名称包含 pattern 的学生
     *
     * @param pattern
     * @return
     */
    @Query("select e from Student e where e.name like :pattern")
    List<Student> findAllWithClassNameLike(String pattern);
}
