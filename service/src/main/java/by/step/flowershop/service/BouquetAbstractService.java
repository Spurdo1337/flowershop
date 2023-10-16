package by.step.flowershop.service;

import by.step.flowershop.mapper.dto.BouquetDto;
import by.step.flowershop.mapper.dto.SellFlowersDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BouquetAbstractService {

    void delete(Long id);

    void addBouquet(BouquetDto bouquetDto);

//    void sellFlower(Long flowerId, int flowerQuantity, Long accessoryId);

    Page<BouquetDto> getAllBouquets(int offset);

    List<BouquetDto> findBouquetById(Long id);

    void sellFlowers(SellFlowersDto sellFlowersDto);

}
