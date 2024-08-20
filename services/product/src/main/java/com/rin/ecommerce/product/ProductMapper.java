package com.rin.ecommerce.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequest request);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "categoryDescription", source = "category.description")
    ProductResponse toProductResponse(Product product);

    @Mapping(target = "quantity", expression = "java(quantity)")
    ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity);
}
