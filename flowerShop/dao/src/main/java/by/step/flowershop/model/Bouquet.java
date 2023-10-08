package by.step.flowershop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bouquet")
public class Bouquet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Long> flowerIds = new ArrayList<>();

    @ElementCollection
    private List<Integer> flowerQuantities = new ArrayList<>();

    private long accessoryId;

    private int accessoryQuantity;

    private double price;

    private Date date;
}
