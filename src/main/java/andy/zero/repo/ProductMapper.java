package andy.zero.repo;

import andy.zero.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface  ProductMapper {
    /**
     * 按照map方式插入数据，map是键值对，插入的时候#{}里面的值将从map中取
     *
     * @param map 需要插入的数据
     * @return 插入成功返回1，失败返回0
     */
    @Insert("insert into product(product_name, product_stock) values(#{product_name, jdbcType=VARCHAR}, #{product_stock, jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);

    /**
     * 直接根据对象属性来进行插入，也就是说直接插入对象到数据库，要保持字段和SQL语句内的预留字段一致
     *
     * @param product 商品对象
     * @return 插入成功返回1，失败返回0
     */
    @Insert("insert into product(product_name, product_stock) values(#{productName, jdbcType=VARCHAR}, #{productStock, jdbcType=INTEGER})")
    int insertByObject(Product product);

    /**
     * 根据ID来查询商品，由于ID是独一唯二的，所以只会查询到一条数据或者0条，用Product对象来接收数据,
     * 注意：接收数据要进行映射才可以接收成功，用Results注解来映射
     *
     * @param productId 商品ID
     * @return Product对象
     */
    @Select("select * from product where product_id = #{productId}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_stock", property = "productStock")
    })
    Product findByProductId(Integer productId);

    /**
     * 当商品名字重复是时候，我们根据商品名字查询，将查询到多条数据，这时候应该使用List来接收数据
     *
     * @param productName 商品名字
     * @return 商品的集合
     */
    @Select("select * from product where product_name = #{productName}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_stock", property = "productStock")
    })
    List<Product> findByProductName(String productName);

    /**
     * 根据一个字段ID来修改商品名称，当传入多个参数的时候，需要使用@Param注解来是SQL语句中名字和参数名字一致，这样就不会出错
     *
     * @param productId   商品ID
     * @param productName 商品名称
     * @return 更新成功返回1，失败返回0
     */
    @Update("update product set product_name = #{productName} where product_id = #{productId}")
    int updateByProductId(@Param("productId") Integer productId, @Param("productName") String productName);

    /**
     * 根据一个对象来更新数据
     *
     * @param product 商品对象
     * @return 更新成功返回1，失败返回0
     */
    @Update("update product set product_name = #{productName} where product_id = #{productId}")
    int updateByObject(Product product);

    /**
     * 根据ID来删除记录，也可以根据对象来删除，道理和上面的更新一致
     *
     * @param productId 商品ID
     * @return 删除成功返回1，失败返回0
     */
    @Delete("delete from product where product_id = #{productId}")
    int deleteByProductId(Integer productId);
}
