package com.dioneadam.salesystem.api.rest.request;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Introspected
public class SaleRequest {

    @NotBlank
    private SalesmanSaleRequest salesman;
    @NotBlank
    private List<ProductSaleRequest> products;

    public SalesmanSaleRequest getSalesman() {
        return salesman;
    }

    public void setSalesman(SalesmanSaleRequest salesman) {
        this.salesman = salesman;
    }

    public List<ProductSaleRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSaleRequest> products) {
        this.products = products;
    }

    public static final class Builder {

        private SalesmanSaleRequest salesman;
        private List<ProductSaleRequest> products;

        private Builder() { }

        public static Builder of() {
            return new Builder();
        }

        public Builder salesman(final SalesmanSaleRequest salesman) {
            this.salesman = salesman;
            return this;
        }

        public Builder products(final List<ProductSaleRequest> products) {
            this.products = products;
            return this;
        }

        public SaleRequest build() {
            final SaleRequest request = new SaleRequest();

            request.setSalesman(salesman);
            request.setProducts(products);

            return request;
        }
    }
}
