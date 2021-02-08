package com.dioneadam.salesystem.api.rest.response;

import io.micronaut.core.annotation.Introspected;

import java.util.UUID;

@Introspected
public class SalesmanResponse {

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
}
