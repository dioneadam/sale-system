package com.dioneadam.salesystem.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity(name="SALESMAN")
public class Salesman {

    @Id
    @Column(updatable = false, nullable = false)
    private UUID registration;

    @Column
    @Size(max = 50)
    private String name;

    @OneToMany(mappedBy = "salesman")
    private List<Sale> sales;

    public Salesman() {
    }

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
