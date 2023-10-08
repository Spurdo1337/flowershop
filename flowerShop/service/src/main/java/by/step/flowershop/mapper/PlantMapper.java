package by.step.flowershop.mapper;

import by.step.flowershop.mapper.dto.PlantDto;
import by.step.flowershop.model.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PlantMapper {

    Plant plantDtoToPlant (PlantDto plantDto);

    PlantDto plantToPlantDto (Plant plant);
}
