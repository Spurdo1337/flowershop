package by.step.flowershop.service;


import by.step.flowershop.mapper.AccessoryMapper;
import by.step.flowershop.mapper.dto.AccessoryDto;
import by.step.flowershop.mapper.dto.BouquetDto;
import by.step.flowershop.model.Accessory;
import by.step.flowershop.model.Bouquet;
import by.step.flowershop.repository.AccessoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccessoryService implements AccessoryAbstractService{

    private final AccessoryRepository accessoryRepository;

    private final AccessoryMapper accessoryMapper;

    @Override
    public void delete(Long id) {
       accessoryRepository.deleteById(id);
    }

    @Override
    public void addAccessory(AccessoryDto accessoryDto) {
        Accessory accessory = accessoryMapper.accessoryDtoToAccessory(accessoryDto);
        accessoryRepository.save(accessory);
    }

    @Override
    public Page<AccessoryDto> getAllAccessories(int offset) {
        PageRequest pageRequest = PageRequest.of(offset, 50);
        Page<Accessory> accessoryPage = accessoryRepository.findAll(pageRequest);
        return accessoryPage.map(accessoryMapper::accessoryToAccessoryDto);
    }

    @Override
    public void updateQuantity(Long id, int quantity) {
        accessoryRepository.updateQuantity(id, quantity);
    }

    @Override
    public List<AccessoryDto> findAccessoryById(Long id) {
        List<Accessory> accessory = accessoryRepository.findAccessoryById(id);
        return accessory.stream().map(accessoryMapper::accessoryToAccessoryDto).collect(Collectors.toList());
    }

    @Override
    public void updatePrice(Long id, double price) {
        accessoryRepository.updatePrice(id, price);
    }
}
