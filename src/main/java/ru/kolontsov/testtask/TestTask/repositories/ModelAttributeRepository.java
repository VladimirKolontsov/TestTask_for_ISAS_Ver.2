package ru.kolontsov.testtask.TestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolontsov.testtask.TestTask.entities.ModelAttributeEntity;

@Repository
public interface ModelAttributeRepository extends JpaRepository<ModelAttributeEntity, Long> {
}
