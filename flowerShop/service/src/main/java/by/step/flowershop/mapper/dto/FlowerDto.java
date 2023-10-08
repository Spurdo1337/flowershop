package by.step.flowershop.mapper.dto;

import lombok.Data;

@Data
public class FlowerDto {

    private Long id;
    private String name;
    private String color;
    private int quantity;
    private double price;
}
