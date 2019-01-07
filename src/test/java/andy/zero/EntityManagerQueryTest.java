package andy.zero;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * 演示通过 EntityManager 操作原生 SQL，和结果集转换到领域模型对象
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class EntityManagerQueryTest {
    @Autowired
    EntityManager em;


    private void loadEntity(String sql) {
        System.out.println("jpql : " + sql);

        List list = em.createQuery(sql).getResultList();
        list.forEach(o -> {
            if (o instanceof Object[]) {
                Object[] columns = (Object[]) o;
                Arrays.stream(columns).forEach(column -> {
                    if (column != null)
                        System.out.print(column.getClass().getSimpleName() + " ");
                });
                System.out.print(" => ");
                System.out.println(Arrays.toString(columns));
            } else {
                System.out.print(o.getClass().getSimpleName() + " ");
                System.out.print(" => ");
                System.out.println(o);
            }
        });
    }

    @Test
    public void testLoadEntity() {
        loadEntity("Select s from Student s");
        loadEntity("Select g from Grade g");
        // 多实体联合查询,IN,子查询
        loadEntity("Select g,s from Grade g,Student s where s.gradeId = g.id AND s.id in (Select s.id from Student s)");
    }
}
