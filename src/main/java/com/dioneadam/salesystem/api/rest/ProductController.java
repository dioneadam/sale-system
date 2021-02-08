package com.dioneadam.salesystem.api.rest;

import com.dioneadam.salesystem.api.rest.request.ProductRequest;
import com.dioneadam.salesystem.api.rest.response.ProductResponse;
import com.dioneadam.salesystem.dto.ProductDto;
import com.dioneadam.salesystem.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

import javax.validation.Valid;
import java.util.UUID;

@Controller("/product")
public class ProductController {

    private final ProductService productService;
    private final ObjectMapper objectMapper;

    public ProductController(ProductService productService, ObjectMapper objectMapper) {
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    @Post
    public HttpResponse<ProductResponse> createProduct(@Valid ProductRequest productRequest) {
        ProductDto product = objectMapper.convertValue(productRequest, ProductDto.class);
        ProductDto createdProduct = productService.createProduct(product);
        return HttpResponse.ok(objectMapper.convertValue(createdProduct, ProductResponse.class));
    }

    @Delete(value = "/{id}")
    public HttpResponse<?> deleteProduct(UUID id) {
        return productService.findProduct(id)
                .map(product -> {
                    productService.removeProduct(product.getId());
                    return HttpResponse.ok(objectMapper.convertValue(product, ProductResponse.class));
                })
                .orElse(HttpResponse.notFound());
    }

    @Put(value = "/{id}")
    public HttpResponse<?> updateProduct(UUID id, ProductRequest productRequest) {
        ProductDto productToUpdate = objectMapper.convertValue(productRequest, ProductDto.class);
        return productService.findProduct(id)
                .map(product -> {
                    ProductDto updatedProduct = productService.updateProduct(product.getId(), productToUpdate);
                    return HttpResponse.ok(objectMapper.convertValue(updatedProduct, ProductResponse.class));
                })
                .orElse(HttpResponse.notFound());
    }

}