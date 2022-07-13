package com.jonson.orderservice.web.rest;

import com.jonson.orderservice.dto.OrderDTO;
import com.jonson.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/order")
public class OrderResource {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderDTO orderDTO) {
        orderService.saveOrder(orderDTO);
        return "Order placed successfully";
    }
}
