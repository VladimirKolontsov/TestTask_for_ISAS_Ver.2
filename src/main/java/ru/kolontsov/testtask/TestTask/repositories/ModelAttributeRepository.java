package ru.kolontsov.testtask.TestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolontsov.testtask.TestTask.models.ModelAttribute;

@Repository
public interface ModelAttributeRepository extends JpaRepository<ModelAttribute, Integer> {
}
