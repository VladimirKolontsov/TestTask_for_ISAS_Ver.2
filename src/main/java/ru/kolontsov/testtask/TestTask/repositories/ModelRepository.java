package ru.kolontsov.testtask.TestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
    List<ModelEntity> findAllByIdIn(List<Long> typeIdList);
    List<ModelEntity> findAllByIdInAndColorIgnoreCase(List<Long> typeIdList, String color);
    @Query(value = "select * from product_type t join product_model m on t.id = m.product_type_id\n" +
            "         where t.name = 'TV' and m.price between 70000 and 89000",
    nativeQuery = true)
    List<ModelEntity> findAllByProductTypeIdInAndPrice(List<Long> typeIdList, int price);


}
