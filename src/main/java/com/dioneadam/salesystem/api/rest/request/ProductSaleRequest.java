package com.dioneadam.salesystem.api.rest.request;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.UUID;

@Introspected
public class ProductSaleRequest {

    @NotBlank
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

    public static final class Builder {

        private UUID id;
        private String name;
        private BigDecimal price;

        private Builder() {
        }

        public static ProductSaleRequest.Builder of() {
            return new Builder();
        }

        public Builder id(final UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder price(final BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductSaleRequest build() {
            final ProductSaleRequest request = new ProductSaleRequest();

            request.setId(id);
            request.setName(name);
            request.setPrice(price);

            return request;
        }
    }

}
