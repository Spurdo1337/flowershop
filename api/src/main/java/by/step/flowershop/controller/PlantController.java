package by.step.flowershop.controller;

import by.step.flowershop.mapper.dto.PlantDto;
import by.step.flowershop.service.PlantAbstractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plants")
@Tag(name = "Plant", description = "for work with user endpoints")
public class PlantController {

    private final PlantAbstractService plantAbstractService;

    public PlantController(PlantAbstractService plantAbstractService) {
        this.plantAbstractService = plantAbstractService;
    }

    @PostMapping
    void addPlant(@RequestBody PlantDto plantDto) {
        plantAbstractService.addPlant(plantDto);
    }

    @DeleteMapping
    void delete(@RequestParam Long id) {
        plantAbstractService.delete(id);
    }

    @GetMapping("getRemainingQuantity")
    int remainingQuantity(@RequestParam Long id) {
        return plantAbstractService.remainingQuantity(id);
    }

    @PutMapping("updateQuantity")
    void updateQuantity(@RequestParam Long id, int quantity) {
        plantAbstractService.updateQuantity(id, quantity);
    }

    @PutMapping("updatePrice")
    public void updatePrice(@RequestParam Long id, double price) {
        plantAbstractService.updatePrice(id, price);
    }

    @GetMapping("getAllPlants")
    Page<PlantDto> getAllPlants(@RequestParam int offset) {
        return plantAbstractService.getAllPlants(offset);
    }

    @GetMapping("findPlantById")
    List<PlantDto> findPlantById(@RequestParam Long id) {
        return plantAbstractService.findPlantById(id);
    }

    @GetMapping("findPlantByName")
    List<PlantDto> findPlantByName(@RequestParam String name) {
        return plantAbstractService.findPlantByName(name);
    }

    @GetMapping("findAllByPriceBetweenOrderByPriceAsc")
    List<PlantDto> findAllByPriceBetweenOrderByPriceAsc(@RequestParam double price1, double price2) {
        return plantAbstractService.findAllByPriceBetweenOrderByPriceAsc(price1, price2);
    }

    @GetMapping("findAllByPriceBetweenOrderByPriceAscPage")
    public Page<PlantDto> findAllByPriceBetweenOrderByPriceAscPage(@RequestParam double price1, double price2, int offset) {
        return plantAbstractService.findAllByPriceBetweenOrderByPriceAscPage(price1, price2, offset);
    }


}
