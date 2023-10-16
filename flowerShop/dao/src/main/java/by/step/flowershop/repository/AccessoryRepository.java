package by.step.flowershop.repository;

import by.step.flowershop.model.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

    List<Accessory> findAccessoryById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Accessory a SET a.quantity = :quantity WHERE a.id = :id")
    void updateQuantity(Long id, int quantity);

    @Query("SELECT a.quantity FROM Accessory a WHERE a.id = :id")
    int remainingQuantity(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Accessory a SET a.price = :price WHERE a.id = :id")
    void updatePrice(Long id, double price);

    @Query("SELECT a.price FROM Accessory a WHERE a.id = :accessoryId")
    Double findPriceById(Long accessoryId);


}
