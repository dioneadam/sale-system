package com.dioneadam.salesystem.api.rest.response;

import io.micronaut.core.annotation.Introspected;

import java.math.BigDecimal;
import java.util.UUID;

@Introspected
public class ProductResponse {

    private UUID id;
    private String name;
    private BigDecimal price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
