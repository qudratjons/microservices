package com.jonson.inventoryservice.web.rest;

import com.jonson.inventoryservice.dto.InventoryResponse;
import com.jonson.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryResource {

    private final InventoryService inventoryService;

    @GetMapping
    public List<InventoryResponse> isInStuck(@RequestParam List<String> skuCode) {
        return inventoryService.isInStuck(skuCode);
    }
}
