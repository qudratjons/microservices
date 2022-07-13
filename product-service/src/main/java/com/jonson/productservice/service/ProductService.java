package com.jonson.productservice.service;

import com.jonson.productservice.dto.ProductDTO;
import com.jonson.productservice.model.Product;
import com.jonson.productservice.repository.ProductRepository;
import com.jonson.productservice.utils.ConvertUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO) {
        log.info("Saving new product");
        return productRepository.save(productDTO.toEntity());
    }

    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(Product::toDto);
    }
}
