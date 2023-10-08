package by.step.flowershop.service;

import by.step.flowershop.mapper.dto.SaleDto;
import by.step.flowershop.model.Sale;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SaleAbstractService {

    void sellPlantById(Long plantId, int quantity);

    List<Sale> findSaleById(Long id);

    Page<SaleDto> getAllSales(int offset);

}
