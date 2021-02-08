package com.dioneadam.salesystem.service;

import com.dioneadam.salesystem.dto.ProductDto;
import com.dioneadam.salesystem.entity.Product;
import com.dioneadam.salesystem.repository.ProductRepository;
import com.dioneadam.salesystem.stub.ProductStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Mock
    ObjectMapper objectMapper;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateProduct() {
        MockitoAnnotations.openMocks(ProductServiceTest.class);

        ProductDto productDto = ProductStub.createProductDtoWithoutId();
        Product product = ProductStub.createProductWithoutId();

        when(objectMapper.convertValue(any(ProductDto.class), eq(Product.class)))
                .thenReturn(product);

        when(productRepository.save(any()))
                .thenReturn(product);

        when(objectMapper.convertValue(any(Product.class), eq(ProductDto.class)))
                .thenReturn(productDto);

        final ProductDto createdProduct = productService.createProduct(productDto);

        Assertions.assertThat(createdProduct)
                .usingRecursiveComparison()
                .isEqualTo(productDto);

        Assertions.assertThat(product.getId()).isNotNull();
    }

}