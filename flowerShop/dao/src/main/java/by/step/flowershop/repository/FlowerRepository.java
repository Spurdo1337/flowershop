package by.step.flowershop.repository;

import by.step.flowershop.model.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FlowerRepository extends JpaRepository<Flower, Long> {

    List<Flower> findFlowerById(Long id);

    @Query("SELECT f.quantity FROM Flower f WHERE f.id = :id")
    int remainingQuantity(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Flower f SET f.quantity = :quantity WHERE f.id = :id")
    void updateQuantity(Long id, int quantity);

    @Modifying
    @Transactional
    @Query("UPDATE Flower f SET f.price = :price WHERE f.id = :id")
    void updatePrice(Long id, double price);

    @Query("SELECT f.price FROM Flower f WHERE f.id = :flowerId")
    Double findPriceById(Long flowerId);

    List<Flower> findFlowerByName(String name);

    Page<Flower> findAllByPriceBetweenOrderByPriceAsc(double price1, double price2, PageRequest pageRequest);
}
