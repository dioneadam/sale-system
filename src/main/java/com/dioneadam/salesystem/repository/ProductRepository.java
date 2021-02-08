package com.dioneadam.salesystem.repository;

import com.dioneadam.salesystem.entity.Product;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {

    @Query("SELECT p FROM PRODUCT p LEFT JOIN p.sales s GROUP BY p.id ORDER BY COUNT(s) DESC")
    List<Product> listProductsOrderByHighestSales();

}
