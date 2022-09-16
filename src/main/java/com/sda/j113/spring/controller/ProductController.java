package com.sda.j113.spring.controller;

import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import com.sda.j113.spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Create -> Post  [/ **Put]
    // Read   -> Get
    // Update -> Put, Patch [*Post]
    // Delete -> Delete

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin

    public List<ProductDTO> getListOfProducts() {
        return productService.listProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ProductDTO postNewProduct(@RequestBody CreateProductRequest request) {
        return productService.addProduct(request);
    }

    @DeleteMapping("/{identifier}")
    @CrossOrigin
    public void deleteProduct(@PathVariable(name = "identifier") Long productId) {
        productService.deleteById(productId);
    }

}
