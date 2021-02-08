package com.dioneadam.salesystem.service;

import com.dioneadam.salesystem.dto.ProductDto;
import com.dioneadam.salesystem.entity.Product;
import com.dioneadam.salesystem.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public ProductService(ProductRepository productRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = objectMapper.convertValue(productDto, Product.class);
        defineIdToProduct(null, product);
        return objectMapper.convertValue(productRepository.save(product), ProductDto.class);
    }

    public Optional<ProductDto> findProduct(UUID id) {
        return productRepository.findById(id).map(product -> objectMapper.convertValue(product, ProductDto.class));
    }

    public void removeProduct(UUID id) {
        productRepository.deleteById(id);
    }

    public ProductDto updateProduct(UUID id, ProductDto productDto) {
        Product product = objectMapper.convertValue(productDto, Product.class);
        defineIdToProduct(id, product);
        return objectMapper.convertValue(productRepository.update(product), ProductDto.class);
    }

    public List<Product> listProductsOrderByHighestSales() {
        return productRepository.listProductsOrderByHighestSales();
    }

    private void defineIdToProduct(UUID id, Product product) {
        product.setId(id != null ? id : UUID.randomUUID());
    }

}
