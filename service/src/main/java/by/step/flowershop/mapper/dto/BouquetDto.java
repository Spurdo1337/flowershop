package by.step.flowershop.mapper.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class BouquetDto {

    private Long id;
    private List<Long> flowerIds = new ArrayList<>();
    private List<Integer> flowerQuantities = new ArrayList<>();
    private long accessoryId;
    private int accessoryQuantity;
    private double price;
    private Date date;
}
