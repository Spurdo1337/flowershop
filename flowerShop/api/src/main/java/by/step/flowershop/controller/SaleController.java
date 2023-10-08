package by.step.flowershop.controller;

import by.step.flowershop.mapper.dto.SaleDto;
import by.step.flowershop.model.Sale;
import by.step.flowershop.service.SaleAbstractService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@Tag(name = "Sales", description = "for work with user endpoints")
public class SaleController {

    private final SaleAbstractService saleAbstractService;

    public SaleController(SaleAbstractService saleAbstractService) {
        this.saleAbstractService = saleAbstractService;
    }

    @PostMapping
    void sellPlantById(@RequestParam Long plantId, int quantity) {
         saleAbstractService.sellPlantById(plantId, quantity);
    }

    @GetMapping
    List<Sale> findSaleById(@RequestParam Long id) {
        return saleAbstractService.findSaleById(id);
    }


}
