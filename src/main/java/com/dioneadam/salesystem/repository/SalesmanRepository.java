package com.dioneadam.salesystem.repository;

import com.dioneadam.salesystem.entity.Salesman;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SalesmanRepository extends CrudRepository<Salesman, UUID> {
    @Query("SELECT sm FROM SALESMAN sm LEFT JOIN SALE s ON s.salesman.id = sm.id GROUP BY sm.id ORDER BY COUNT(s.id) DESC")
    List<Salesman> listSalesmenOrderByHighestSales();

    @Query("SELECT sm FROM SALESMAN sm LEFT JOIN SALE s ON s.salesman.id = sm.id GROUP BY sm.id ORDER BY SUM(s.amount) DESC")
    List<Salesman> listSalesmenOrderByHighestAmount();
}
