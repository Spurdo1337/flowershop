package by.step.flowershop.service;

import by.step.flowershop.mapper.dto.AccessoryDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccessoryAbstractService {

    void delete(Long id);

    void addAccessory(AccessoryDto accessoryDto);

    Page<AccessoryDto> getAllAccessories(int offset);

    List<AccessoryDto> findAccessoryById(Long id);

    void updatePrice(Long id, double price);

    void updateQuantity(Long id, int quantity);

}
