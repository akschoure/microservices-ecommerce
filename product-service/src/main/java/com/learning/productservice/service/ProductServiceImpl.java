package com.learning.productservice.service;

import com.learning.productservice.dao.ProductRepository;
import com.learning.productservice.dto.ProductRequest;
import com.learning.productservice.dto.ProductResponse;
import com.learning.productservice.entity.Product;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(productRequest.getId())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

           log.info("product {} is saved",product.getId());

        return   productRepository.save(product);

    }

    @Override
    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }
    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }
}
