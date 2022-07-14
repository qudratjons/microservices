package com.jonson.productservice.model;

import com.jonson.productservice.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDTO toDto() {
        ProductDTO productDto = new ProductDTO();
        BeanUtils.copyProperties(this, productDto);
        return productDto;
    }

}
