package ru.kolontsov.testtask.TestTask.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kolontsov.testtask.TestTask.dto.TypeDto;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.entities.Types;
import ru.kolontsov.testtask.TestTask.repositories.TypeRepository;
import ru.kolontsov.testtask.TestTask.repositories.TypesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TypeEntityService {
    private final TypeRepository typeRepository;
    private final TypesRepository typesRepository;

    public TypeEntityService(TypeRepository typeRepository, TypesRepository typesRepository) {
        this.typeRepository = typeRepository;
        this.typesRepository = typesRepository;
    }

    public List<TypeEntity> findByTypesName(List<String> names) {
        return typeRepository.findAllByTypesNameInIgnoreCase(names);
    }

    @Transactional
    public TypeEntity createNewModelEntityAndAddItToTypeEntity(TypeDto typeDto) {

        Long typesId = typeDto.getTypesId();
        Optional<Types> typesById = typesRepository.findById(typesId);

        TypeEntity typeEntity = new TypeEntity();
        typeEntity.setCountry(typeDto.getCountry());
        typeEntity.setBrand(typeDto.getBrand());
        typeEntity.setIsOnlineOrder(typeDto.getIsOnlineOrder());
        typeEntity.setIsCredit(typeDto.getIsCredit());
        typeEntity.setTypes(typesById.orElse(null));

        TypeEntity typeEntityNew = typeRepository.saveAndFlush(typeEntity);

        return typeEntityNew;
    }

}