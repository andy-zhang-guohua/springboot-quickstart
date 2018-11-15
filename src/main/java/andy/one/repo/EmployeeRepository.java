package andy.one.repo;

import andy.one.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    /**
     * 找到所有名字包含 pattern 的班级
     * 如果不指定SQL的话，方法名称一定要使用 JPA 规定的形式 findBy+参数名+Like(参数)
     *
     * @param pattern
     * @return
     */
    @Query(value = "select c from Employee c where c.name like %:pattern%")
    List<Employee> findByNameLike(@Param("pattern") String pattern);
}
