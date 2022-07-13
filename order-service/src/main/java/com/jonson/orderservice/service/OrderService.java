package com.jonson.orderservice.service;

import com.jonson.orderservice.dto.InventoryResponse;
import com.jonson.orderservice.dto.OrderDTO;
import com.jonson.orderservice.dto.OrderLineItemsDTO;
import com.jonson.orderservice.model.Order;
import com.jonson.orderservice.model.OrderLineItems;
import com.jonson.orderservice.repositry.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder httpClient;

    public void saveOrder(OrderDTO orderDTO) {

        Order order = new Order()
                .setOrderNumber(UUID.randomUUID().toString())
                .setOrderLineItems(orderDTO.getOrderLineItems()
                        .stream()
                        .map(OrderLineItemsDTO::toEntity)
                        .collect(Collectors.toList())
                );

        List<String> skuCodeList = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        InventoryResponse[] inventoryResponses = httpClient.build().get()
                .uri("lb://inventory/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodeList).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

        if (allProductsInStock && inventoryResponses.length != 0)
            orderRepository.save(order);
        else
            throw new IllegalArgumentException("InStuck");
    }
}
