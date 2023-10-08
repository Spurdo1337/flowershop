package by.step.flowershop.service;

import by.step.flowershop.mapper.dto.PlantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface PlantAbstractService {

    void addPlant(PlantDto plantDto);

    void delete(Long id);

    int remainingQuantity(Long id);

    void updateQuantity(Long id, int quantity);

    void updatePrice(Long id, double price);

    Page<PlantDto> getAllPlants(int offset);

    List<PlantDto> findPlantById(Long id);

    List<PlantDto> findPlantByName(String name);

    List<PlantDto> findAllByPriceBetweenOrderByPriceAsc(double price1, double price2);

    Page<PlantDto> findAllByPriceBetweenOrderByPriceAscPage(double price1, double price2, int offset);
}
