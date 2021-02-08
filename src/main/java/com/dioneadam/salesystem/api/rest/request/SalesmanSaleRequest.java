package com.dioneadam.salesystem.api.rest.request;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class SalesmanSaleRequest {

    @NotBlank
    private UUID registration;
    private String name;

    public UUID getRegistration() {
        return registration;
    }

    public void setRegistration(UUID registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class Builder {

        private UUID registration;
        private String name;

        private Builder() { }

        public static Builder of() {
            return new Builder();
        }

        public Builder registration(final UUID registration) {
            this.registration = registration;
            return this;
        }

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public SalesmanSaleRequest build() {
            final SalesmanSaleRequest request = new SalesmanSaleRequest();

            request.setRegistration(registration);
            request.setName(name);

            return request;
        }
    }

}
