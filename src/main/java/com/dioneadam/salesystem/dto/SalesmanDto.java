package com.dioneadam.salesystem.dto;

import io.micronaut.core.annotation.Introspected;

import java.util.UUID;

@Introspected
public class SalesmanDto {

    private UUID registration;
    private String name;

    public SalesmanDto() { }

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
