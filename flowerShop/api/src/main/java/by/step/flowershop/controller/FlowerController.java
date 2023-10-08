package by.step.flowershop.controller;


import by.step.flowershop.mapper.dto.FlowerDto;
import by.step.flowershop.service.FlowerAbstractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flowers")
@Tag(name = "Flower", description = "for work with user endpoints")
public class FlowerController {

    private final FlowerAbstractService flowerAbstractService;


    public FlowerController(FlowerAbstractService flowerAbstractService) {
        this.flowerAbstractService = flowerAbstractService;
    }

    @PostMapping
    public void addFlower(@RequestBody FlowerDto flowerDto) {
        flowerAbstractService.addFlower(flowerDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        flowerAbstractService.delete(id);
    }

    @GetMapping
    public int remainingQuantity(@RequestParam Long id) {
        return flowerAbstractService.remainingQuantity(id);
    }

    @PutMapping("updateQuantity")
    public void updateQuantity(@RequestParam Long id, int quantity) {
        flowerAbstractService.updateQuantity(id, quantity);
    }

    @PutMapping("updatePrice")
    public void updatePrice(@RequestParam Long id, double price) {
        flowerAbstractService.updatePrice(id, price);
    }

    @GetMapping("getAllFlowers")
    public Page<FlowerDto> getAllFlowers(@RequestParam int offset) {
        return flowerAbstractService.getAllFlowers(offset);
    }

    @GetMapping("findFlowerById")
    public List<FlowerDto> findFlowerById(@RequestParam Long id) {
        return flowerAbstractService.findFlowerById(id);
    }

    @GetMapping("findFlowerByName")
    public List<FlowerDto> findFlowerByName(@RequestParam String name) {
        return flowerAbstractService.findFlowerByName(name);
    }

    @GetMapping("findAllByPriceBetweenOrderByPriceAsc")
    public Page<FlowerDto> findAllByPriceBetweenOrderByPriceAsc(@RequestParam double price1, double price2, int offset) {
       return flowerAbstractService.findAllByPriceBetweenOrderByPriceAsc(price1, price2, offset);
    }
}
