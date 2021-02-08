package com.dioneadam.salesystem.repository;

import com.dioneadam.salesystem.entity.Sale;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface SaleRepository extends CrudRepository<Sale, UUID> {

}
