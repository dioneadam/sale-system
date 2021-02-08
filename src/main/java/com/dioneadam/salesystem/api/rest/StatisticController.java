package com.dioneadam.salesystem.api.rest;

import com.dioneadam.salesystem.api.rest.response.ProductResponse;
import com.dioneadam.salesystem.api.rest.response.SalesmanResponse;
import com.dioneadam.salesystem.entity.Product;
import com.dioneadam.salesystem.entity.Salesman;
import com.dioneadam.salesystem.service.ProductService;
import com.dioneadam.salesystem.service.SalesmanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/statistic")
public class StatisticController {

    private final ProductService productService;
    private final SalesmanService salesmanService;
    private final ObjectMapper objectMapper;

    public StatisticController(ProductService productService, SalesmanService salesmanService, ObjectMapper objectMapper) {
        this.productService = productService;
        this.salesmanService = salesmanService;
        this.objectMapper = objectMapper;
    }

    @Get(value = "salesmen/sales")
    public HttpResponse<List<SalesmanResponse>> listSalesmenOrderByHighestSales() {
        List<Salesman> salesmen = salesmanService.listSalesmenOrderByHighestSales();
        return HttpResponse.ok(salesmen
                .stream()
                .map(salesman -> objectMapper.convertValue(salesman, SalesmanResponse.class))
                .collect(Collectors.toList()));
    }

    @Get(value = "salesmen/amount")
    public HttpResponse<List<SalesmanResponse>> listSalesmenOrderByHighestAmount() {
        List<Salesman> salesmen = salesmanService.listSalesmenOrderByHighestAmount();
        return HttpResponse.ok(salesmen
                .stream()
                .map(salesman -> objectMapper.convertValue(salesman, SalesmanResponse.class))
                .collect(Collectors.toList()));
    }

    @Get(value = "products/sales")
    public HttpResponse<List<ProductResponse>> listProductsOrderBySales() {
        List<Product> products = productService.listProductsOrderByHighestSales();
        return HttpResponse.ok(products
                .stream()
                .map(product -> objectMapper.convertValue(product, ProductResponse.class))
                .collect(Collectors.toList()));
    }

}