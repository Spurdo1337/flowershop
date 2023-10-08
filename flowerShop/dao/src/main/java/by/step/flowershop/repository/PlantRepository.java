package by.step.flowershop.repository;

import by.step.flowershop.model.Plant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findPlantById(Long id);

    @Query("SELECT p.quantity FROM Plant p WHERE p.id = :id")
    int remainingQuantity(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Plant p SET p.quantity = :quantity WHERE p.id = :id")
    void updateQuantity(Long id, int quantity);

    @Modifying
    @Transactional
    @Query("UPDATE Plant p SET p.price = :price WHERE p.id = :id")
    void updatePrice(Long id, double price);

    List<Plant> findPlantsByName(String name);

    List<Plant> findAllByPriceBetweenOrderByPriceAsc(double price1, double price2);

    Page<Plant> findAllByPriceBetweenOrderByPriceAsc(double price1, double price2, PageRequest pageRequest);
}
