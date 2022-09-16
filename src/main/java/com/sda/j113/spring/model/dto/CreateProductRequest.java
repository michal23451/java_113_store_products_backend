package com.sda.j113.spring.model.dto;

import com.sda.j113.spring.model.ProductState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {
    private String productName;
    private ProductState productState;
}
