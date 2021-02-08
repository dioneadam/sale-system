package com.dioneadam.salesystem.api.rest.request;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Introspected
public class ProductRequest {

    @NotBlank
    private String name;
    @NotBlank
    private BigDecimal price;

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

        private String name;
        private BigDecimal price;

        private Builder() { }

        public static Builder of() {
            return new ProductRequest.Builder();
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder price(final BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductRequest build() {
            final ProductRequest request = new ProductRequest();

            request.setName(name);
            request.setPrice(price);

            return request;
        }
    }

}
