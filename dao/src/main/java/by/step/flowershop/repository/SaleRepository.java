package by.step.flowershop.repository;

import by.step.flowershop.model.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findSaleById(Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sales (plant_id, quantity, price, date) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void sellPlant(Long plantId, int quantity, double price, Date date);
}
