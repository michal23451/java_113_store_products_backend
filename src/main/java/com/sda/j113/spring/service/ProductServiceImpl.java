package com.sda.j113.spring.service;

import com.sda.j113.spring.model.Product;
import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import com.sda.j113.spring.model.mapper.ProductMapper;
import com.sda.j113.spring.model.mapper.ProductMapperImpl;
import com.sda.j113.spring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapperImpl productMapper;

    @Override
    public ProductDTO addProduct(CreateProductRequest request) {
        Product newProduct = productMapper.mapCreateProductRequestToProduct(request);
        return productMapper.mapProductToProductDTO(productRepository.save(newProduct));
    }

    @Override
    public List<ProductDTO> listProducts() {
        List<ProductDTO> productDTOList = productRepository.findAll()
                .stream()
                .map(p -> productMapper.mapProductToProductDTO(p))
                .collect(Collectors.toList());
        return productDTOList;
    }

    @Override
    public void deleteById(Long studentId) {
        productRepository.deleteById(studentId);
    }
}
