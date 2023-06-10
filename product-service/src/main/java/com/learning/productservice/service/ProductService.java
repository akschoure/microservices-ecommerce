package com.learning.productservice.service;

import com.learning.productservice.dto.ProductRequest;
import com.learning.productservice.dto.ProductResponse;
import com.learning.productservice.entity.Product;

import java.util.List;

public interface ProductService {


    Product createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
