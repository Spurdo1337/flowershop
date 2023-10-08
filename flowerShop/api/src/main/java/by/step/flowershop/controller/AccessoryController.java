package by.step.flowershop.controller;


import by.step.flowershop.mapper.dto.AccessoryDto;
import by.step.flowershop.service.AccessoryAbstractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accessories")
@Tag(name = "Accessory", description = "for work with user endpoints")
public class AccessoryController {

    private final AccessoryAbstractService accessoryAbstractService;

    public AccessoryController(AccessoryAbstractService accessoryAbstractService) {
        this.accessoryAbstractService = accessoryAbstractService;
    }

    @DeleteMapping
    void delete(@RequestParam Long id){
        accessoryAbstractService.delete(id);
    }

    @PostMapping
    void addAccessory(@RequestBody AccessoryDto accessoryDto) {
        accessoryAbstractService.addAccessory(accessoryDto);
    }

    @GetMapping
    Page<AccessoryDto> getAllAccessories(@RequestParam int offset) {
        return accessoryAbstractService.getAllAccessories(offset);
    }

    @GetMapping("findAccessoryById")
    List<AccessoryDto> findAccessoryById(@RequestParam Long id){
        return accessoryAbstractService.findAccessoryById(id);
    }

    @PutMapping
    void updatePrice(@RequestParam Long id, double price){
        accessoryAbstractService.updatePrice(id, price);
    }

    @PutMapping("updateQuantity")
    void updateQuantity(@RequestParam Long id, int quantity){
        accessoryAbstractService.updateQuantity(id, quantity);
    }
}
