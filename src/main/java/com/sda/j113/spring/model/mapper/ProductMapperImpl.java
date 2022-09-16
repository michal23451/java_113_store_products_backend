package com.sda.j113.spring.model.mapper;

import com.sda.j113.spring.model.ApplicationUser;
import com.sda.j113.spring.model.Product;
import com.sda.j113.spring.model.dto.ApplicationUserDTO;
import com.sda.j113.spring.model.dto.CreateProductRequest;
import com.sda.j113.spring.model.dto.CreateUserRequest;
import com.sda.j113.spring.model.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {

    private final ApplicationUserMapper applicationUserMapper;

    @Override
    public Product mapCreateProductRequestToProduct(CreateProductRequest request) {
        if ( request == null ) {
            return null;
        }

        CreateUserRequest productOwner = request.getProductOwner();
        ApplicationUser applicationUser = applicationUserMapper.mapCreateUserRequestToApplicationUser(productOwner);

        Product.ProductBuilder product = Product.builder();

        product.name( request.getProductName() );
        product.state( request.getProductState() );
        product.owner( applicationUser );

        return product.build();
    }

    @Override
    public ProductDTO mapProductToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ApplicationUser owner = product.getOwner();
        ApplicationUserDTO applicationUserDTO = applicationUserMapper.mapApplicationUserToDTO(owner);


        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setProductName( product.getName() );
        productDTO.setProductState( product.getState() );
        productDTO.setProductOwner( applicationUserDTO );

        return productDTO;
    }
}