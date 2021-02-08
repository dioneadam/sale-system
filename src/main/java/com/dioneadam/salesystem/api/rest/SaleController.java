package com.dioneadam.salesystem.api.rest;

import com.dioneadam.salesystem.api.rest.request.SaleRequest;
import com.dioneadam.salesystem.api.rest.response.SaleResponse;
import com.dioneadam.salesystem.dto.SaleDto;
import com.dioneadam.salesystem.service.SaleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;

@Controller("/sale")
public class SaleController {

    private final SaleService saleService;
    private final ObjectMapper objectMapper;

    public SaleController(SaleService saleService, ObjectMapper objectMapper) {
        this.saleService = saleService;
        this.objectMapper = objectMapper;
    }

    @Post
    public HttpResponse<SaleResponse> createSale(@Valid SaleRequest saleRequest) {
        SaleDto sale = objectMapper.convertValue(saleRequest, SaleDto.class);
        SaleDto createdSale = saleService.createSale(sale);
        return HttpResponse.ok(objectMapper.convertValue(createdSale, SaleResponse.class));
    }

}