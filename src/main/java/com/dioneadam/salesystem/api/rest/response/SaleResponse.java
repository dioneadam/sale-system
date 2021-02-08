package com.dioneadam.salesystem.api.rest.response;

import io.micronaut.core.annotation.Introspected;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Introspected
public class SaleResponse {

    private UUID id;
    private SalesmanResponse salesman;
    private List<ProductResponse> products;
    private BigDecimal amount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SalesmanResponse getSalesman() {
        return salesman;
    }

    public void setSalesman(SalesmanResponse salesman) {
        this.salesman = salesman;
    }

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
