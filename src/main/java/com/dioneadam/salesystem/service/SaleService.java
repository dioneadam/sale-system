package com.dioneadam.salesystem.service;

import com.dioneadam.salesystem.dto.SaleDto;
import com.dioneadam.salesystem.entity.Sale;
import com.dioneadam.salesystem.mapper.SaleMapper;
import com.dioneadam.salesystem.repository.SaleRepository;

import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    public SaleDto createSale(SaleDto saleDto) {
        Sale sale = saleMapper.toEntity(saleDto);
        defineIdToSale(sale);
        return saleMapper.toDto(saleRepository.save(sale));
    }

    private void defineIdToSale(Sale sale) {
        sale.setId(UUID.randomUUID());
    }

}
