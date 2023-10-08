package by.step.flowershop.controller;

import by.step.flowershop.mapper.dto.BouquetDto;
import by.step.flowershop.mapper.dto.SellFlowersDto;
import by.step.flowershop.service.BouquetAbstractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bouquets")
@Tag(name = "Bouquet", description = "for work with user endpoints")
public class BouquetController {

    private final BouquetAbstractService bouquetAbstractService;


    public BouquetController(BouquetAbstractService bouquetAbstractService) {
        this.bouquetAbstractService = bouquetAbstractService;
    }

    @DeleteMapping
    void delete(@RequestParam Long id) {
        bouquetAbstractService.delete(id);
    }

//    @PostMapping
//    void addBouquet(@RequestBody BouquetDto bouquetDto) {
//        bouquetAbstractService.addBouquet(bouquetDto);
//    }

    @GetMapping("getAllBouquets")
    Page<BouquetDto> getAllBouquets(@RequestParam int offset) {
        return bouquetAbstractService.getAllBouquets(offset);
    }

    @GetMapping
    List<BouquetDto> findBouquetById(@RequestParam Long id) {
        return bouquetAbstractService.findBouquetById(id);
    }

//    @PostMapping("sellFlower")
//    void sellFlower(@RequestParam Long flowerId, int flowerQuantity, Long accessoryId) {
//        bouquetAbstractService.sellFlower(flowerId, flowerQuantity, accessoryId);
//    }

    @PostMapping("sellFlowers")
    public void sellFlowers(@RequestBody SellFlowersDto sellFlowersDto) {
        bouquetAbstractService.sellFlowers(sellFlowersDto);
    }

}
