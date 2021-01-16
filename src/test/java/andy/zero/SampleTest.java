package andy.zero;

import andy.zero.entity.User;
import andy.zero.repo.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper mapper;


    @Test
    public void testCRUD() {
        log.info(("----- CRUD 测试 ------"));

        // 初始值查询
        {
            List<User> userList = mapper.selectList(null);
            Assert.assertEquals(5, userList.size());
            userList.forEach(System.out::println);
        }

        // 增加
        User user = new User();

        user.setId(RandomUtils.nextLong());
        user.setName(RandomStringUtils.randomAlphanumeric(20));
        user.setAge(RandomUtils.nextInt(1, 60));
        user.setEmail(RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphabetic(3) + ".com");
        Assert.assertEquals(1, mapper.insert(user));

        // 增加后查询
        {
            List<User> userList = mapper.selectList(null);
            Assert.assertEquals(6, userList.size());
            userList.forEach(System.out::println);
        }

        // 真删除
        Assert.assertEquals(1, mapper.deleteById(user.getId()));

        // 重复删除 : 并不真正发生，因为相应记录已经被删除
        Assert.assertEquals(0, mapper.deleteById(user.getId()));
        // 删除后查询
        {
            List<User> userList = mapper.selectList(null);
            Assert.assertEquals(5, userList.size());
            userList.forEach(System.out::println);
        }

        {
            // 待条件查询
            // SELECT * FROM user WHERE age >= 20
            List<User> userList = mapper.selectList(
                    new QueryWrapper<User>()
                            .lambda()
                            .ge(User::getAge, 20)
            );

            Assert.assertEquals(4, userList.size());
        }

        // 更新测试
        {
            // 更新用户1
            assertThat(mapper.updateById(new User().setId(1L).setEmail("ab@c.c"))).isGreaterThan(0);
            assertThat(mapper.selectById(1).getEmail()).isEqualTo("ab@c.c");

            // 更新用户2
            assertThat(mapper.update(new User().setName("mp"),
                    Wrappers.<User>lambdaUpdate().set(User::getAge, 3).eq(User::getId, 2))
            ).isGreaterThan(0);

            User userWithId2 = mapper.selectById(2);
            assertThat(userWithId2.getAge()).isEqualTo(3);
            assertThat(userWithId2.getName()).isEqualTo("mp");

            // 更新用户2
            mapper.update(null,
                    Wrappers.<User>lambdaUpdate().set(User::getEmail, null).eq(User::getId, 2)
            );

            userWithId2 = mapper.selectById(2);
            assertThat(userWithId2.getEmail()).isNull();
            assertThat(userWithId2.getName()).isEqualTo("mp");

            mapper.update(new User().setEmail("miemie@baomidou.com"),
                    new QueryWrapper<User>()
                            .lambda().eq(User::getId, 2)
            );
            userWithId2 = mapper.selectById(2);
            assertThat(userWithId2.getEmail()).isEqualTo("miemie@baomidou.com");

            mapper.update(new User().setEmail("miemie2@baomidou.com"),
                    Wrappers.<User>lambdaUpdate()
                            .set(User::getAge, null)
                            .eq(User::getId, 2)
            );
            userWithId2 = mapper.selectById(2);
            assertThat(userWithId2.getEmail()).isEqualTo("miemie2@baomidou.com");
            assertThat(userWithId2.getAge()).isNull();
        }
    }
}