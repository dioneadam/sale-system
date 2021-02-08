package com.dioneadam.salesystem.stub;

import com.dioneadam.salesystem.dto.ProductDto;
import com.dioneadam.salesystem.entity.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductStub {

    public static ProductDto createProductDtoWithoutId() {
        ProductDto product = new ProductDto();
        product.setName("productTest");
        product.setPrice(new BigDecimal("19.99"));
        return product;
    }

    public static ProductDto createProductDtoWithId(UUID id) {
        ProductDto product = new ProductDto();
        product.setId(id);
        product.setName("productTest");
        product.setPrice(new BigDecimal("19.99"));
        return product;
    }

    public static Product createProductWithoutId() {
        Product product = new Product();
        product.setName("productTest");
        product.setPrice(new BigDecimal("19.99"));
        return product;
    }


}
