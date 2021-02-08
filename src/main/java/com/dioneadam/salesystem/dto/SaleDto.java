package com.dioneadam.salesystem.dto;

import io.micronaut.core.annotation.Introspected;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Introspected
public class SaleDto {

    private UUID id;
    private SalesmanDto salesman;
    private List<ProductDto> products;
    private BigDecimal amount;

    public SaleDto() { }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SalesmanDto getSalesman() {
        return salesman;
    }

    public void setSalesman(SalesmanDto salesman) {
        this.salesman = salesman;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
