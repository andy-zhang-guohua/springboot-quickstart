package andy.zero;

import andy.zero.entity.Product;
import andy.zero.repo.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
//@MapperScan(basePackages = {"andy.zero.repo"})
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@SpringBootTest(classes = Application.class)
public class ProductMapperTest {
    @Autowired
    private ProductMapper mapper;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", "" + 1);
        map.put("name", "apple");
        map.put("stock", 200);
        int result = mapper.insertByMap(map);
        // 下面这一句是检测返回结果是否为1，不为1将报错
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        Product product = new Product();
        product.setId(RandomStringUtils.randomAlphanumeric(20));
        product.setName("banana");
        product.setStock(10);
        int result = mapper.insertByObject(product);
        // 下面这一句是检测返回结果是否为1，不为1将报错
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByProductId() {
        Product result = mapper.findById("" + 1);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductName() {
        String name = "apple";
        List<Product> result = mapper.findByName(name);
        log.info("名字为 {}的产品一共有 {} 个", name, result.size());
    }

    @Test
    public void updateByProductId() {
        // 将第一条记录的名字由apple改成orange橙子
        int result = mapper.updateById("1", "orange");
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void updateByObject() {
        // 我们将第一条记录的名字修改成火龙果
        Product product = new Product();
        product.setId("" + 1);
        product.setName("pitaya");
        int result = mapper.updateByObject(product);
        // 下面这一句是检测返回结果是否为1，不为1将报错
        Assert.assertEquals(1, result);
    }

    //@Test
    public void deleteByProductId() {
        int result = mapper.deleteById("" + 1);
        Assert.assertEquals(1, result);
    }
}
