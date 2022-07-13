package com.jonson.productservice.dto;

import com.jonson.productservice.model.Product;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public Product toEntity() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }
}
