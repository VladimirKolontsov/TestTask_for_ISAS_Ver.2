package ru.kolontsov.testtask.TestTask.services;

import org.springframework.stereotype.Service;
import ru.kolontsov.testtask.TestTask.entities.Types;
import ru.kolontsov.testtask.TestTask.repositories.TypesRepository;

import java.util.List;

@Service
public class TypesService {
    private final TypesRepository typesRepository;

    public TypesService(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }

    public List<Types> findAll() {
        return typesRepository.findAll();
    }
}
