package ru.kolontsov.testtask.TestTask.repositories.attributes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolontsov.testtask.TestTask.entities.attributes.TvAttribute;

public interface TvAttributeRepository  extends JpaRepository<TvAttribute, Long> {
}
