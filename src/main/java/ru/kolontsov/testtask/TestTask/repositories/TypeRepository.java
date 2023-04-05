package ru.kolontsov.testtask.TestTask.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    List<TypeEntity> findAllByNameIgnoreCase(String name);


}
