package by.step.flowershop.mapper.dto;

import lombok.Data;

@Data
public class PlantDto {

    private Long id;
    private String name;
    private String info;
    private double price;
    private int quantity;
}
