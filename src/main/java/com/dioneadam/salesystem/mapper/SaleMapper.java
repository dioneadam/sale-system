package com.dioneadam.salesystem.mapper;

import com.dioneadam.salesystem.dto.ProductDto;
import com.dioneadam.salesystem.dto.SalesmanDto;
import com.dioneadam.salesystem.entity.Product;
import com.dioneadam.salesystem.entity.Sale;
import com.dioneadam.salesystem.dto.SaleDto;
import com.dioneadam.salesystem.entity.Salesman;
import com.dioneadam.salesystem.service.ProductService;
import com.dioneadam.salesystem.service.SalesmanService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;
import java.util.stream.Collectors;

@Singleton
public class SaleMapper {

    private final ObjectMapper objectMapper;
    private final ProductService productService;
    private final SalesmanService salesmanService;

    public SaleMapper(ObjectMapper objectMapper, ProductService productService, SalesmanService salesmanService) {
        this.objectMapper = objectMapper;
        this.productService = productService;
        this.salesmanService = salesmanService;
    }

    public Sale toEntity(SaleDto saleDto) {
        return Sale.Builder.of()
                .id(saleDto.getId())
                .salesman(objectMapper.convertValue(salesmanService
                                .findSalesman(saleDto.getSalesman().getRegistration())
                                .orElse(saleDto.getSalesman())
                        ,Salesman.class))
                .products(saleDto.getProducts()
                        .stream()
                        .map(product -> productService.findProduct(product.getId()))
                        .map(product -> objectMapper.convertValue(product, Product.class))
                        .collect(Collectors.toList()))
                .calculateAmount()
                .build();
    }

    public SaleDto toDto(Sale sale) {
        SaleDto saleDto = new SaleDto();
        saleDto.setId(sale.getId());
        saleDto.setSalesman(objectMapper.convertValue(sale.getSalesman(), SalesmanDto.class));
        saleDto.setProducts(sale.getProducts()
                .stream()
                .map(product -> objectMapper.convertValue(product, ProductDto.class))
                .collect(Collectors.toList()));
        saleDto.setAmount(sale.getAmount());
        return saleDto;
    }
}
