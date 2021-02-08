package com.dioneadam.salesystem.service;

import com.dioneadam.salesystem.dto.SalesmanDto;
import com.dioneadam.salesystem.entity.Salesman;
import com.dioneadam.salesystem.repository.SalesmanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class SalesmanService {

    private final SalesmanRepository salesmanRepository;
    private final ObjectMapper objectMapper;

    public SalesmanService(SalesmanRepository salesmanRepository, ObjectMapper objectMapper) {
        this.salesmanRepository = salesmanRepository;
        this.objectMapper = objectMapper;
    }

    public SalesmanDto createSalesman(SalesmanDto salesmanDto) {
        Salesman salesman = objectMapper.convertValue(salesmanDto, Salesman.class);
        defineRegistrationToSalesman(null, salesman);
        return objectMapper.convertValue(salesmanRepository.save(salesman), SalesmanDto.class);
    }

    public Optional<SalesmanDto> findSalesman(UUID registration) {
        return salesmanRepository.findById(registration).map(salesman -> objectMapper.convertValue(salesman, SalesmanDto.class));
    }

    public void removeSalesman(UUID registration) {
        salesmanRepository.deleteById(registration);
    }

    public SalesmanDto updateSalesman(UUID registration, SalesmanDto salesmanDto) {
        Salesman salesman = objectMapper.convertValue(salesmanDto, Salesman.class);
        defineRegistrationToSalesman(registration, salesman);
        return objectMapper.convertValue(salesmanRepository.update(salesman), SalesmanDto.class);
    }

    public List<Salesman> listSalesmenOrderByHighestSales() {
        return salesmanRepository.listSalesmenOrderByHighestSales();
    }

    public List<Salesman> listSalesmenOrderByHighestAmount() {
        return salesmanRepository.listSalesmenOrderByHighestAmount();
    }

    private void defineRegistrationToSalesman(UUID registration, Salesman salesman) {
        salesman.setRegistration(registration != null ? registration : UUID.randomUUID());
    }

}
