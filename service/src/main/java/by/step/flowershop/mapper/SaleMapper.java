package by.step.flowershop.mapper;

import by.step.flowershop.mapper.dto.SaleDto;
import by.step.flowershop.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SaleMapper {

    Sale saleDtoToSale(SaleDto saleDto);

    SaleDto saleToSaleDto (Sale sale);
}
