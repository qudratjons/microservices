package com.jonson.productservice.service;

import com.jonson.productservice.dto.ProductDTO;
import com.jonson.productservice.model.Product;
import com.jonson.productservice.repository.ProductRepository;
import com.jonson.productservice.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record ProductService(
        ProductRepository productRepository,
        ConvertUtils convertUtils) {

    public Product createProduct(ProductDTO productDTO) {
        log.info("Saving new product");
        return productRepository.save(convertUtils.convert(productDTO, Product.class));
    }

    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(product -> convertUtils.convert(product, ProductDTO.class));
    }
}
