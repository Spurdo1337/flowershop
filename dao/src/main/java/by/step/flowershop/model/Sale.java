package by.step.flowershop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    private int quantity;
    private double price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Sale(Long id, Date date, Plant plant, int quantity, double price) {
        this.id = id;
        this.date = date;
        this.plant = plant;
        this.quantity = quantity;
        this.price = price;
    }

    public Sale() {
    }
}
