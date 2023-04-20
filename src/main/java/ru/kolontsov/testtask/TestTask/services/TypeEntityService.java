package ru.kolontsov.testtask.TestTask.services;

import org.springframework.stereotype.Service;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.repositories.TypeRepository;

import java.util.List;

@Service
public class TypeEntityService {
    private final TypeRepository typeRepository;

    public TypeEntityService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<TypeEntity> findByTypesName(String name) {
        return typeRepository.findAllByTypesNameIgnoreCase(name);
    }
}
