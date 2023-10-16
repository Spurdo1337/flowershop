package by.step.flowershop.service;


import by.step.flowershop.mapper.SaleMapper;
import by.step.flowershop.mapper.dto.SaleDto;
import by.step.flowershop.model.Plant;
import by.step.flowershop.model.Sale;
import by.step.flowershop.repository.PlantRepository;
import by.step.flowershop.repository.SaleRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class SaleService implements SaleAbstractService {

    private SaleRepository saleRepository;

    private SaleMapper saleMapper;

    private PlantRepository plantRepository;

    @SneakyThrows
    @Override
    public void sellPlantById(Long id, int quantity) {
        Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Plant not found with ID: " + id));
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive value.");
        }
        int availableQuantity = plant.getQuantity();
        if (quantity > availableQuantity) {
            throw new IllegalArgumentException("Not enough plants available for sale.");
        }
        plantRepository.updateQuantity(id, availableQuantity - quantity);
        double price = plant.getPrice();
        double totalAmount = quantity * price;
        saleRepository.sellPlant(plant.getId(), quantity, totalAmount, new Date());
    }

    @Override
    public List<Sale> findSaleById(Long id) {
        return saleRepository.findSaleById(id);
    }

    @Override
    public Page<SaleDto> getAllSales(int offset) {
        PageRequest pageRequest = PageRequest.of(offset, 50);
        Page<Sale> salePage = saleRepository.findAll(pageRequest);
        return salePage.map(saleMapper::saleToSaleDto);
    }
}
