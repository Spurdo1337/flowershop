package by.step.flowershop.mapper;

import by.step.flowershop.mapper.dto.BouquetDto;
import by.step.flowershop.model.Bouquet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BouquetMapper {

    Bouquet bouquetDtoToBouquet(BouquetDto bouquetDto);

    BouquetDto bouquetToBouquetDto(Bouquet bouquet);

}
