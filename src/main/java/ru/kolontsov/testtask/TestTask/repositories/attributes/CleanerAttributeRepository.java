package ru.kolontsov.testtask.TestTask.repositories.attributes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolontsov.testtask.TestTask.entities.attributes.CleanerAttribute;

public interface CleanerAttributeRepository  extends JpaRepository<CleanerAttribute, Long> {
}
