package by.step.flowershop.service;

import by.step.flowershop.mapper.PlantMapper;
import by.step.flowershop.mapper.dto.PlantDto;
import by.step.flowershop.model.Plant;
import by.step.flowershop.repository.PlantRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlantService implements PlantAbstractService {

    private PlantRepository plantRepository;

    private PlantMapper plantMapper;

    @Override
    public void addPlant(PlantDto plantDto) {
        Plant plant = plantMapper.plantDtoToPlant(plantDto);
        plantRepository.save(plant);
    }

    @Override
    public void delete(Long id) {
        plantRepository.deleteById(id);
    }

    @Override
    public int remainingQuantity(Long id) {
        return plantRepository.remainingQuantity(id);
    }

    @Override
    public void updateQuantity(Long id, int quantity) {
        plantRepository.updateQuantity(id, quantity);
    }

    @Override
    public void updatePrice(Long id, double price) {
        plantRepository.updatePrice(id, price);
    }

    @Override
    public Page<PlantDto> getAllPlants(int offset) {
        PageRequest pageRequest = PageRequest.of(offset, 50);
        Page<Plant> plantPage = plantRepository.findAll(pageRequest);
        return plantPage.map(plantMapper::plantToPlantDto);
    }

    @Override
    public List<PlantDto> findPlantById(Long id) {
        List<Plant> plants = plantRepository.findPlantById(id);
        return plants.stream().map(plantMapper::plantToPlantDto).collect(Collectors.toList());
    }

    @Override
    public List<PlantDto> findPlantByName(String name) {
        List<Plant> plants = plantRepository.findPlantsByName(name);
        return plants.stream().map(plantMapper::plantToPlantDto).collect(Collectors.toList());
    }

    @Override
    public List<PlantDto> findAllByPriceBetweenOrderByPriceAsc(double price1, double price2) {
        List<Plant> plants = plantRepository.findAllByPriceBetweenOrderByPriceAsc(price1, price2);
        return plants.stream().map(plantMapper::plantToPlantDto).collect(Collectors.toList());
    }
    @SneakyThrows
    @Override
    public Page<PlantDto> findAllByPriceBetweenOrderByPriceAscPage(double price1, double price2, int offset) {
        if (offset < 0) {
            throw new IllegalArgumentException("Offset must be a positive value.");
        }
        if (price2 < 0 || price1 < 0) {
            throw new IllegalArgumentException("Price must be a positive value.");
        }
        PageRequest pageRequest = PageRequest.of(offset, 50);
        Page<Plant> plantPage = plantRepository.findAllByPriceBetweenOrderByPriceAsc(price1, price2, pageRequest);
        return plantPage.map(plantMapper::plantToPlantDto);
    }
}
