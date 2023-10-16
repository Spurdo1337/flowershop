package by.step.flowershop.service;

import by.step.flowershop.mapper.dto.FlowerDto;
import by.step.flowershop.model.Flower;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FlowerAbstractService {

    void addFlower(FlowerDto flowerDto);

    void delete(Long id);

    int remainingQuantity(Long id);

    void updateQuantity(Long id, int quantity);

    void updatePrice(Long id, double price);

    Page<FlowerDto> getAllFlowers(int offset);

    List<FlowerDto> findFlowerById(Long id);

    List<FlowerDto> findFlowerByName(String name);

    Page<FlowerDto> findAllByPriceBetweenOrderByPriceAsc(double price1, double price2, int offset);
}
