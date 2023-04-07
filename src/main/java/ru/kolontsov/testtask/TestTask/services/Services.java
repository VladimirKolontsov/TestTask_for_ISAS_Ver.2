package ru.kolontsov.testtask.TestTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.repositories.ModelAttributeRepository;
import ru.kolontsov.testtask.TestTask.repositories.ModelRepository;
import ru.kolontsov.testtask.TestTask.repositories.TypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class Services {
    private final TypeRepository typeRepository;
    private final ModelRepository modelRepository;
    private final ModelAttributeRepository modelAttributeRepository;

    @Autowired
    public Services(TypeRepository typeRepository, ModelRepository modelRepository,
                    ModelAttributeRepository modelAttributeRepository) {
        this.typeRepository = typeRepository;
        this.modelRepository = modelRepository;
        this.modelAttributeRepository = modelAttributeRepository;
    }

    public void findAll() {
        typeRepository.findAll();
    }

    public Optional<TypeEntity> findById(long id) {
        return typeRepository.findById(id);
    }

    // Нахождение List<Long> typeIdList, чтоды использовать в других функциях
    public List<Long> getTypeIdList(String name) {
        List<Long> typeIdList = typeRepository.findAllByNameIgnoreCase(name).stream().
                map(TypeEntity::getId).collect(Collectors.toList());
        return typeIdList;
    }

    // Фильтрация по виду техники: приходит тип техники, выдергивается лист id по типу техники и выходит список моделей этого типа
    public List<ModelEntity> getModelsByTypeName(String name) {
        List<ModelEntity> allModelsByProductTypeName = modelRepository.findAllByIdIn(getTypeIdList(name));
        return allModelsByProductTypeName;
    }

    // Фильтрация по виду техники и ее цвету: приходит тип техники и ее цвет -> выходит список моделей этого типа и цвета
    public List<ModelEntity> getTypeByColor(String name, String color) {
        List<ModelEntity> allModelsByProductTypeAndColor =
                modelRepository.findAllByIdInAndColorIgnoreCase(getTypeIdList(name), color);
        return allModelsByProductTypeAndColor;
    }

    public List<ModelEntity> getTypeByRangeOfPrice(String name, int minPrice, int maxPrice) {

        return null;
    }

    public List<TypeEntity> getTypeByName(String name) {
        List<TypeEntity> allTypesByProductTypeName = typeRepository.findAllByNameIgnoreCase(name);
        return allTypesByProductTypeName;
    }


}
