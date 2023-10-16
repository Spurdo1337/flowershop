package by.step.flowershop.mapper.dto;

import by.step.flowershop.model.Accessory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SellFlowersDto {

    private List<Long> flowerIds = new ArrayList<>();
    private List<Integer> flowerQuantities = new ArrayList<>();
    private Long accessoryId;
}
