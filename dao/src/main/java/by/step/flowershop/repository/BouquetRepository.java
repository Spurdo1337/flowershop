package by.step.flowershop.repository;

import by.step.flowershop.model.Bouquet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BouquetRepository extends JpaRepository<Bouquet, Long> {

    List<Bouquet> findBouquetById (Long id);

}