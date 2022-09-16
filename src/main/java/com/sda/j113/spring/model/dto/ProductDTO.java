package com.sda.j113.spring.model.dto;


import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.ProductState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String productName;
    private ProductState productState;
}
