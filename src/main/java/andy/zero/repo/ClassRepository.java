package andy.zero.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import andy.zero.entity.Class;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long>, JpaSpecificationExecutor<Class> {
    /**
     * 找到所有名字包含 pattern 的班级
     *
     * @param pattern
     * @return
     */
    @Query("select e from Class e where e.name like :pattern")
    List<Class> findAllWithNameLike(String pattern);
}
