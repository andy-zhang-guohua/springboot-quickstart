package andy.zero;

import andy.zero.entity.User;
import andy.zero.repo.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testCRUD() {
        log.info(("----- CRUD 测试 ------"));

        // 初始值查询
        {
            List<User> userList = userMapper.selectList(null);
            Assert.assertEquals(5, userList.size());
            userList.forEach(System.out::println);
        }

        // 增加
        User user = new User();

        user.setId(RandomUtils.nextLong());
        user.setName(RandomStringUtils.randomAlphanumeric(20));
        user.setAge(RandomUtils.nextInt(1, 60));
        user.setEmail(RandomStringUtils.randomAlphanumeric(10) + "@" + RandomStringUtils.randomAlphabetic(3) + ".com");
        Assert.assertEquals(1, userMapper.insert(user));

        // 增加后查询
        {
            List<User> userList = userMapper.selectList(null);
            Assert.assertEquals(6, userList.size());
            userList.forEach(System.out::println);
        }

        // 真删除
        Assert.assertEquals(1, userMapper.deleteById(user.getId()));

        // 重复删除 : 并不真正发生，因为相应记录已经被删除
        Assert.assertEquals(0, userMapper.deleteById(user.getId()));
        // 删除后查询
        {
            List<User> userList = userMapper.selectList(null);
            Assert.assertEquals(5, userList.size());
            userList.forEach(System.out::println);
        }
    }
}