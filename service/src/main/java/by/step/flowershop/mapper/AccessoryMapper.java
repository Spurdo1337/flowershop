package by.step.flowershop.mapper;

import by.step.flowershop.mapper.dto.AccessoryDto;
import by.step.flowershop.model.Accessory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccessoryMapper {

    Accessory accessoryDtoToAccessory(AccessoryDto accessoryDto);

    AccessoryDto accessoryToAccessoryDto(Accessory accessory);
}