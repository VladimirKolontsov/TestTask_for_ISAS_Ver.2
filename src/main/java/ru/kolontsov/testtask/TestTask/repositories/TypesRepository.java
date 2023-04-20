package ru.kolontsov.testtask.TestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolontsov.testtask.TestTask.entities.Types;

public interface TypesRepository extends JpaRepository<Types, Long> {

}

