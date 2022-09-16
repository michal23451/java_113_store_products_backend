package com.sda.j113.spring.service;

import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(CreateProductRequest request);
    List<ProductDTO> listProducts();
    void deleteById(Long productId);
}
