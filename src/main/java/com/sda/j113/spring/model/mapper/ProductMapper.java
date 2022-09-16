package com.sda.j113.spring.model.mapper;

import com.sda.j113.spring.model.Product;
import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings(value = {
            @Mapping(target = "id", ignore = true), //można tego nie dawać
            @Mapping(target = "name", source = "productName"),
            @Mapping(target = "createDateTime", ignore = true),
            @Mapping(target = "updateDateTime", ignore = true),
            @Mapping(target = "state", source = "productState"),
            @Mapping(target = "owner", ignore = true),
            @Mapping(target = "auctions", ignore = true)
    })
    Product mapCreateProductRequestToProduct(CreateProductRequest request);

    @Mappings(value = {
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "productName"),
            @Mapping(source = "state", target = "productState"),
    })
    ProductDTO mapProductToProductDTO(Product product);
}
