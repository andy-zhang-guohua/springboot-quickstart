package andy.zero.justJPA.jpql;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

/**
 * 演示通过 EntityManager 操作 JPQL，和结果集转换到领域模型对象
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class EntityManagerJPQLTest {


    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    EntityManager entityManager;


    private void query(String sql) {
        log.info("JPQL : {}", sql);

        Query query = entityManager.createQuery(sql);

        List rows = query.getResultList();
        rows.forEach(row -> {
            StringBuilder sbEntityNames = new StringBuilder();
            if (row instanceof Object[]) {
                Object[] entities = (Object[]) row;
                Arrays.stream(entities).forEach(entity -> {
                    if (entity != null)
                        sbEntityNames.append(entity.getClass().getSimpleName() + " ");
                });
                sbEntityNames.append(" => ");
                log.info("{}{}", sbEntityNames.toString(), Arrays.toString(entities));
            } else {
                String entityName = row.getClass().getSimpleName();
                log.info("{} => {}", entityName, row);
            }
        });
    }

    @Test
    public void testQuery() {
        // 查询所有学生
        query("SELECT s FROM Student s");

        // 查询所有班级
        query("SELECT g FROM Grade g");

        // 查询所有学生及其班级信息，
        // 多实体联合查询,IN,子查询，这里 IN 子查询要不要都行，这里使用的目的是为了演示其可用
        query("SELECT g,s FROM Grade g,Student s WHERE s.gradeId = g.id AND s.id IN (SELECT s.id FROM Student s)");
    }
}
