package by.step.flowershop.service;

import by.step.flowershop.mapper.BouquetMapper;
import by.step.flowershop.mapper.dto.BouquetDto;
import by.step.flowershop.mapper.dto.SellFlowersDto;
import by.step.flowershop.model.Accessory;
import by.step.flowershop.model.Bouquet;
import by.step.flowershop.model.Flower;
import by.step.flowershop.repository.AccessoryRepository;
import by.step.flowershop.repository.BouquetRepository;
import by.step.flowershop.repository.FlowerRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BouquetService implements BouquetAbstractService {

    private final BouquetRepository bouquetRepository;
    private final BouquetMapper bouquetMapper;
    private final AccessoryRepository accessoryRepository;
    private final FlowerRepository flowerRepository;


    @Override
    public void delete(Long id) {
        bouquetRepository.deleteById(id);
    }

    @Override
    public void addBouquet(BouquetDto bouquetDto) {
        Bouquet bouquet = bouquetMapper.bouquetDtoToBouquet(bouquetDto);
        bouquetRepository.save(bouquet);
    }

//    @SneakyThrows
//    @Override
//    public void sellFlower(Long flowerId, int flowerQuantity, Long accessoryId) {
//        flowerRepository.findById(flowerId)
//                .orElseThrow(() -> new IllegalArgumentException("Flower not found with ID: " + flowerId));
//
//        int flowerQuantityInStock = flowerRepository.remainingQuantity(flowerId);
//        if (flowerQuantityInStock < flowerQuantity) {
//            throw new IllegalArgumentException("Not enough flowers in stock.");
//        }
//
//        accessoryRepository.findById(accessoryId)
//                .orElseThrow(() -> new IllegalArgumentException("Accessory not found with ID: " + accessoryId));
//
//        int accessoryQuantityInStock = accessoryRepository.remainingQuantity(accessoryId);
//        if (accessoryQuantityInStock < 1) {
//            throw new IllegalArgumentException("Not enough accessories in stock.");
//        }
//
//        double totalPrice = (flowerRepository.findPriceById(flowerId) * flowerQuantity)
//                + accessoryRepository.findPriceById(accessoryId);
//
//        Bouquet bouquet = new Bouquet();
//        bouquet.setFlowerIds(Collections.singletonList(flowerId));
//        bouquet.setFlowerQuantities(Collections.singletonList(flowerQuantity));
//        bouquet.setAccessoryId(accessoryId);
//        bouquet.setAccessoryQuantity(1);
//        bouquet.setPrice(totalPrice);
//        bouquet.setDate(new Date());
//        bouquetRepository.save(bouquet);
//
//        flowerRepository.updateQuantity(flowerId, flowerQuantityInStock - flowerQuantity);
//        accessoryRepository.updateQuantity(accessoryId, accessoryQuantityInStock - 1);
//    }

    @SneakyThrows
    @Override
    public void sellFlowers(SellFlowersDto sellFlowersDto) {
        List<Long> flowerIds = sellFlowersDto.getFlowerIds();
        List<Integer> flowerQuantities = sellFlowersDto.getFlowerQuantities();
        Long accessoryId = sellFlowersDto.getAccessoryId();

        if (flowerIds.size() != flowerQuantities.size()) {
            throw new IllegalArgumentException("Number of flower IDs must match the number of flower quantities.");
        }

        double totalPrice = 0;

        for (int i = 0; i < flowerIds.size(); i++) {
            Long flowerId = flowerIds.get(i);
            int flowerQuantity = flowerQuantities.get(i);

            int flowerQuantityInStock = flowerRepository.remainingQuantity(flowerId);
            flowerRepository.findById(flowerId)
                    .orElseThrow(() -> new IllegalArgumentException("Flower not found with ID: " + flowerId));

            if (flowerQuantityInStock < flowerQuantity) {
                throw new IllegalArgumentException("Not enough flowers in stock for flower with ID: " + flowerId);
            }

            totalPrice += flowerRepository.findPriceById(flowerId) * flowerQuantity;

            flowerRepository.updateQuantity(flowerId, flowerQuantityInStock - flowerQuantity);
        }

        int accessoryQuantityInStock = accessoryRepository.remainingQuantity(accessoryId);
        accessoryRepository.findById(accessoryId)
                .orElseThrow(() -> new IllegalArgumentException("Accessory not found with ID: " + accessoryId));

        if (accessoryQuantityInStock < 1) {
            throw new IllegalArgumentException("Not enough accessories in stock.");
        }

        totalPrice += accessoryRepository.findPriceById(accessoryId);

        Bouquet bouquet = new Bouquet();
        bouquet.setFlowerIds(flowerIds);
        bouquet.setFlowerQuantities(flowerQuantities);
        bouquet.setAccessoryId(accessoryId);
        bouquet.setAccessoryQuantity(1);
        bouquet.setPrice(totalPrice);
        bouquet.setDate(new Date());
        bouquetRepository.save(bouquet);

        accessoryRepository.updateQuantity(accessoryId, accessoryQuantityInStock - 1);
    }


    @Override
    public Page<BouquetDto> getAllBouquets(int offset) {
        PageRequest pageRequest = PageRequest.of(offset, 50);
        Page<Bouquet> bouquetPage = bouquetRepository.findAll(pageRequest);
        return bouquetPage.map(bouquetMapper::bouquetToBouquetDto);
    }

    @Override
    public List<BouquetDto> findBouquetById(Long id) {
        List<Bouquet> bouquet = bouquetRepository.findBouquetById(id);
        return bouquet.stream().map(bouquetMapper::bouquetToBouquetDto).collect(Collectors.toList());
    }
}
