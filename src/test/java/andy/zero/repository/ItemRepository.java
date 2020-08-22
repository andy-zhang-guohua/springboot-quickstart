package andy.zero.repository;

import andy.zero.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item, Long> {
    List<Item> findByPriceBetween(double price1, double price2);

    List<Item> findByTitleLike(String pattern);

    List<Item> findByTitleLikeAndPriceBetween(String pattern, double price1, double price2);
}
