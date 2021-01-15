package andy.zero.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Product implements Serializable {

    /**
     * 产品ID
     */
    private String id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 库存数量
     */
    private int stock;
}
