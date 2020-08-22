package andy.zero;

import andy.zero.entity.Item;
import andy.zero.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ElasticSearchTest {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    ItemRepository itemRepository;

    /**
     * 创建索引Index
     */
    @Before
    public void createIndex() {
        elasticsearchRestTemplate.createIndex(Item.class);
    }

    @Ignore
    @Test
    public void testAddListAndQuery() {
        List<Item> list = new LinkedList<>();
        list.add(new Item(1L, "小米手机7", "手机", "小米", 3499.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "mobile", "华为", 4499.00, "http://image.baidu.com/13123.jpg"));
        list.add(new Item(4L, "大米手机6", "mobile", "大米", 3899.00, "http://image.baidu.com/13153.jpg"));
        itemRepository.saveAll(list);

        {
            log.info("所有商品:");
            Iterable<Item> result = itemRepository.findAll();
            for (Item item : result) {
                log.info("{}", item);
            }
        }

        {
            log.info("所有商品:小米");
            Iterable<Item> result = itemRepository.findByTitleLike("小米");
            for (Item item : result) {
                log.info("{}", item);
            }
        }

        {
            log.info("所有商品:价格在3000-4000");
            Iterable<Item> result = itemRepository.findByPriceBetween(3000, 4000);
            for (Item item : result) {
                log.info("{}", item);
            }
        }

        {
            log.info("所有商品:*米 并且 价格在3000-4000");
            Iterable<Item> result = itemRepository.findByTitleLikeAndPriceBetween("米", 3000, 4000);
            for (Item item : result) {
                log.info("{}", item);
            }
        }
    }


    @Test
    public void testAddAndUpdate() {
        long id = RandomUtils.nextLong();
        {
            Item item = new Item(id, "苹果XSMax", " 手机", "小米", 3499.00, "http://image.baidu.com/13123.jpg");
            itemRepository.save(item);
        }

        {
            Item item = new Item(id, "苹果XSMax", " 手机", "苹果", 3499.00, "http://image.baidu.com/13123.jpg");
            itemRepository.save(item);
        }
    }


    /**
     * @Description:matchQuery
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Test
    public void testMatchQuery() {
        // 创建对象
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 在queryBuilder对象中自定义查询
        //matchQuery:底层就是使用的termQuery
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "坚果"));
        //查询，search 默认就是分页查找
        Page<Item> page = itemRepository.search(queryBuilder.build());
        //获取数据
        long totalElements = page.getTotalElements();
        System.out.println("获取的总条数:" + totalElements);

        for (Item item : page) {
            System.out.println(item);
        }
    }


    /**
     * @Description: termQuery:功能更强大，除了匹配字符串以外，还可以匹配
     * int/long/double/float/....
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Test
    public void testTermQuery() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.termQuery("price", 4499.0));
        //builder.withQuery(QueryBuilders.termQuery("category", "mobile"));
        // 查找
        Page<Item> page = this.itemRepository.search(builder.build());

        for (Item item : page) {
            System.out.println(item);
        }
    }

    /**
     * @Description:布尔查询
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Test
    public void testBooleanQuery() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();

        builder.withQuery(
                QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("title", "华为"))
                        .must(QueryBuilders.matchQuery("brand", "华为"))
        );

        // 查找
        Page<Item> page = this.itemRepository.search(builder.build());
        for (Item item : page) {
            System.out.println(item);
        }
    }

    /**
     * @Description:模糊查询
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Test
    public void testFuzzyQuery() {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.fuzzyQuery("title", "faceoooo"));
        Page<Item> page = this.itemRepository.search(builder.build());
        for (Item item : page) {
            System.out.println(item);
        }

    }

    /**
     * @Description:分页查询
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Test
    public void searchByPage() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("category", "手机"));
        // 分页：
        int page = 0;
        int size = 2;
        queryBuilder.withPageable(PageRequest.of(page, size));

        // 搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        System.out.println("总条数 = " + total);
        // 总页数
        System.out.println("总页数 = " + items.getTotalPages());
        // 当前页
        System.out.println("当前页：" + items.getNumber());
        // 每页大小
        System.out.println("每页大小：" + items.getSize());

        for (Item item : items) {
            System.out.println(item);
        }
    }


    @After
    public void deleteIndex() {
        //elasticsearchTemplate.deleteIndex(Item.class);
    }
}
