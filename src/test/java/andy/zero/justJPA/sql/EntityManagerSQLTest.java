package andy.zero.justJPA.sql;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.List;

/**
 * 演示通过 EntityManager 操作原生 SQL，和结果集转换到领域模型对象
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class EntityManagerSQLTest {
    @Autowired
    EntityManager em;


    public static void nativeQuery(EntityManager em, String s) {
        System.out.printf("'%s'%n", s);
        Query query = em.createNativeQuery(s);
        List list = query.getResultList();
        for (Object o : list) {
            if (o instanceof Object[]) {
                Object[] columns = (Object[]) o;
                Arrays.stream(columns).forEach(column -> {
                    if (column != null)
                        System.out.print(column.getClass().getSimpleName() + " ");
                });
                System.out.print( " => ");
                System.out.println(Arrays.toString(columns));
            } else {
                System.out.print(o.getClass().getSimpleName() + " ");
                System.out.print( " => ");
                System.out.println(o);
            }
        }
    }

    @Test
    public void testNativeQuery() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        nativeQuery(em, "SHOW TABLES");
        nativeQuery(em, "SHOW COLUMNS from student");
        nativeQuery(em, "SHOW COLUMNS from grade");
        nativeQuery(em, "select * from student");
        nativeQuery(em, "select * from grade");
        nativeQuery(em, "select s.*,g.name as grade_name from grade g,student s where g.id=s.grade_id");
    }
}
