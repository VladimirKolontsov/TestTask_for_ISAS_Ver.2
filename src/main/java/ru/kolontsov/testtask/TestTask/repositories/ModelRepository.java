package ru.kolontsov.testtask.TestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    List<ModelEntity> findAllByTypeEntityNameInIgnoreCase(List<String> nameTypeEntityList);

    List<ModelEntity> findAllByColorInIgnoreCase(List<String> color);

    List<ModelEntity> findModelEntitiesByPriceBetween (int minPrice, int maxPrice);
    List<ModelEntity> findAllByTypeEntityNameInIgnoreCaseAndAndIsInStock(List<String> name, boolean isInStock);
    List<ModelEntity> findAllByTypeEntityNameInIgnoreCaseAndSizeBetween(List<String> name, int min, int max);

    List<ModelEntity> findAllByTypeEntityNameIgnoreCaseOrderByName (String name);

    List<ModelEntity> findAllByTypeEntityNameIgnoreCaseOrderByNameDesc (String name);

    List<ModelEntity> findAllByTypeEntityNameIgnoreCaseOrderByPrice (String name);

    List<ModelEntity> findAllByTypeEntityNameIgnoreCaseOrderByPriceDesc (String name);

    @Query(value = """
            select pm.*
            from product_type pt
            join product_model pm on pt.id = pm.product_type_id
            join product_model_attribute pma on pm.id = pma.product_model_id
            where  pt.name = :typeName and pma.name = :attName and pma.value = :attValue""", nativeQuery = true)
    List<ModelEntity> findAllByAttributes(String typeName, String attName, String attValue);

}
