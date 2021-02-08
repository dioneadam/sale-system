package com.dioneadam.salesystem.api.rest;

import com.dioneadam.salesystem.api.rest.request.SalesmanRequest;
import com.dioneadam.salesystem.api.rest.response.SalesmanResponse;
import com.dioneadam.salesystem.dto.SalesmanDto;
import com.dioneadam.salesystem.service.SalesmanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Controller("/salesman")
public class SalesmanController {

    private final SalesmanService salesmanService;
    private final ObjectMapper objectMapper;

    public SalesmanController(SalesmanService salesmanService, ObjectMapper objectMapper) {
        this.salesmanService = salesmanService;
        this.objectMapper = objectMapper;
    }

    @Post
    public HttpResponse<SalesmanResponse> createSalesman(@Valid SalesmanRequest salesmanRequest) {
        SalesmanDto salesman = objectMapper.convertValue(salesmanRequest, SalesmanDto.class);
        SalesmanDto createdSalesman = salesmanService.createSalesman(salesman);
        return HttpResponse.ok(objectMapper.convertValue(createdSalesman, SalesmanResponse.class));
    }

    @Get(value = "/{registration}")
    public HttpResponse<?> findSalesman(UUID registration) {
        return salesmanService.findSalesman(registration)
                .map(salesman -> HttpResponse.ok(objectMapper.convertValue(salesman, SalesmanResponse.class)))
                .orElse(HttpResponse.badRequest());
    }

    @Delete(value = "/{registration}")
    public HttpResponse<?> deleteSalesman(UUID registration) {
        return salesmanService.findSalesman(registration)
                .map(salesman -> {
                    salesmanService.removeSalesman(salesman.getRegistration());
                    return HttpResponse.ok(objectMapper.convertValue(salesman, SalesmanResponse.class));
                })
                .orElse(HttpResponse.notFound());
    }

    @Put(value = "/{registration}")
    public HttpResponse<?> updateSalesman(UUID registration, SalesmanRequest salesmanRequest) {
        SalesmanDto salesmanToUpdate = objectMapper.convertValue(salesmanRequest, SalesmanDto.class);
        return salesmanService.findSalesman(registration)
                .map(salesman -> {
                    SalesmanDto updatedSalesman = salesmanService.updateSalesman(salesman.getRegistration(), salesmanToUpdate);
                    return HttpResponse.ok(objectMapper.convertValue(updatedSalesman, SalesmanResponse.class));
                })
                .orElse(HttpResponse.notFound());
    }

}