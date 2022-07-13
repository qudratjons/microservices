package com.jonson.orderservice.dto;

import com.jonson.orderservice.model.OrderLineItems;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
public class OrderLineItemsDTO {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

    public OrderLineItems toEntity() {
        OrderLineItems orderLineItems = new OrderLineItems();
        BeanUtils.copyProperties(this, orderLineItems);
        return orderLineItems;
    }
}
