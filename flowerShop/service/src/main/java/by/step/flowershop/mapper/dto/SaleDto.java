package by.step.flowershop.mapper.dto;

import by.step.flowershop.model.Plant;
import lombok.Data;



import java.util.Date;

@Data
public class SaleDto {

    private Long id;
    private Plant plant;
    private int quantity;
    private double price;
    private Date date;
}
