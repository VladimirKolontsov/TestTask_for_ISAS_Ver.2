package ru.kolontsov.testtask.TestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

    List<ModelEntity> findAllByColorInIgnoreCase(List<String> color);

    List<ModelEntity> findModelEntitiesByPriceBetween (BigDecimal minPrice, BigDecimal maxPrice);

    List<ModelEntity> findAllByIsInStock(boolean isInStock);

    List<ModelEntity> findAllBySizeBetween(int min, int max);

    //for sorting, I used parameter "isInStock" because there is no reason to sort products,
    //which is not in the stock
    List<ModelEntity> findAllByIsInStockOrderByNameAsc(boolean isInStock);

    List<ModelEntity> findAllByIsInStockOrderByNameDesc(boolean isInStock);

    List<ModelEntity> findAllByIsInStockOrderByPriceAsc(boolean isInStock);

    List<ModelEntity> findAllByIsInStockOrderByPriceDesc(boolean isInStock);

}