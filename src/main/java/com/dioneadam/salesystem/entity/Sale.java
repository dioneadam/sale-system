package com.dioneadam.salesystem.entity;

import com.dioneadam.salesystem.dto.ProductDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity(name="SALE")
public class Sale {

    @Id
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "salesman_registration", referencedColumnName = "registration")
    private Salesman salesman;

    @ManyToMany
    @JoinTable(
            name = "product_sale",
            joinColumns = @JoinColumn(name = "sale_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products;

    @Column
    private BigDecimal amount;

    public Sale() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getCalculatedAmount() {
        return products
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    };

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public static final class Builder {

        private UUID id;
        private Salesman salesman;
        private List<Product> products;
        private BigDecimal amount;

        private Builder() { }

        public static Builder of() {
            return new Builder();
        }

        public Builder id(final UUID id) {
            this.id = id;
            return this;
        }

        public Builder salesman(final Salesman salesman) {
            this.salesman = salesman;
            return this;
        }

        public Builder products(final List<Product> products) {
            this.products = products;
            return this;
        }

        public Builder calculateAmount() {
            this.amount = getCalculatedAmount();
            return this;
        }

        public Sale build() {
            final Sale request = new Sale();

            request.setId(id);
            request.setSalesman(salesman);
            request.setProducts(products);
            request.setAmount(amount);

            return request;
        }

        private BigDecimal getCalculatedAmount() {
            return products
                    .stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        };
    }

}
