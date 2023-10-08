package by.step.flowershop.mapper;

import by.step.flowershop.mapper.dto.FlowerDto;
import by.step.flowershop.model.Flower;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FlowerMapper {

    Flower flowerDtoToFlower (FlowerDto flowerDto);

    FlowerDto flowerToFlowerDto (Flower flower);

}
