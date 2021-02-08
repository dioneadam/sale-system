package com.dioneadam.salesystem.api.rest.request;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected
public class SalesmanRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class Builder {

        private String name;

        private Builder() { }

        public static Builder of() {
            return new SalesmanRequest.Builder();
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public SalesmanRequest build() {
            final SalesmanRequest request = new SalesmanRequest();

            request.setName(name);

            return request;
        }
    }

}
