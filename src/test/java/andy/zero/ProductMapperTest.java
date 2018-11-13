package andy.zero;

import andy.zero.entity.Product;
import andy.zero.repo.ProductMapper;
import lombok.extern.slf4j.Slf4j;
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
        map.put("product_name", "apple");
        map.put("product_stock", 200);
        int result = mapper.insertByMap(map);
        // 下面这一句是检测返回结果是否为1，不为1将报错
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        Product product = new Product();
        product.setProductName("banana");
        product.setProductStock(10);
        int result = mapper.insertByObject(product);
        // 下面这一句是检测返回结果是否为1，不为1将报错
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByProductId() {
        Product result = mapper.findByProductId(1);
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductName() {
        // 由于前面只插入了一个名字为apple的商品，请你在运行这个案例之前在运行一下第一个或者第二个例子，你设置名字还是apple，库存改一下，这样数据库就有两条数据了，方便测试
        List<Product> result = mapper.findByProductName("apple");
        System.out.println("一共查询的数据条数是：" + result.size());
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void updateByProductId() {
        // 将第一条记录的名字由apple改成orange橙子
        int result = mapper.updateByProductId(1, "orange");
        Assert.assertNotEquals(0, result);
    }

    @Test
    public void updateByObject() {
        // 我们将第一条记录的名字修改成火龙果
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("pitaya");
        int result = mapper.updateByObject(product);
        // 下面这一句是检测返回结果是否为1，不为1将报错
        Assert.assertEquals(1, result);
    }

    //@Test
    public void deleteByProductId() {
        int result = mapper.deleteByProductId(1);
        Assert.assertEquals(1, result);
    }
}
