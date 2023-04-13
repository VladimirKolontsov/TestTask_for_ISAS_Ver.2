package ru.kolontsov.testtask.TestTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kolontsov.testtask.TestTask.dto.ModelAttributeDto;
import ru.kolontsov.testtask.TestTask.dto.ModelDto;
import ru.kolontsov.testtask.TestTask.entities.ModelAttributeEntity;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.repositories.ModelAttributeRepository;
import ru.kolontsov.testtask.TestTask.repositories.ModelRepository;
import ru.kolontsov.testtask.TestTask.repositories.TypeRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

    public List<TypeEntity> findAll() {
        return typeRepository.findAll();
    }

    public List<ModelEntity> getModelsByTypeName(List<String> names) {
        return modelRepository.findAllByTypeEntityNameInIgnoreCase(names);
    }

    public List<ModelEntity> getModelsByColor(List<String> color) {
        return modelRepository.findAllByColorInIgnoreCase(color);
    }

    public List<ModelEntity> getModelsByRangeOfPrice (BigDecimal minPrice, BigDecimal maxPrice) {
        return modelRepository.findModelEntitiesByPriceBetween(minPrice, maxPrice);
    }

    public List<ModelEntity> modelsAttribute(String typeName, String attName, String attValue) {
        return modelRepository.findAllByAttributes(typeName, attName, attValue);
    }

    public List<ModelEntity> modelsByTypeNameAndStockAvailable(List<String> typeName, boolean isInStock) {
        return modelRepository.findAllByTypeEntityNameInIgnoreCaseAndAndIsInStock(typeName, isInStock);
    }

    public List<ModelEntity> modelsByTypeNameAndSize(List<String> typeName, int min, int max) {
        return modelRepository.findAllByTypeEntityNameInIgnoreCaseAndSizeBetween(typeName, min, max);
    }

    public List<ModelEntity> modelsSortByName(String name) {
        return modelRepository.findAllByTypeEntityNameIgnoreCaseOrderByName(name);
    }

    public List<ModelEntity> modelsSortByNameDesc(String name) {
        return modelRepository.findAllByTypeEntityNameIgnoreCaseOrderByNameDesc(name);
    }

    public List<ModelEntity> modelsSortByPrice(String name) {
        return modelRepository.findAllByTypeEntityNameIgnoreCaseOrderByPrice(name);
    }

    public List<ModelEntity> modelsSortByPriceDesc(String name) {
        return modelRepository.findAllByTypeEntityNameIgnoreCaseOrderByPriceDesc(name);
    }

    @Transactional
    public ModelEntity createNewModelEntity(ModelDto modelDto) {

        Long typeId = modelDto.getTypeId();
        Optional<TypeEntity> typeEntity = typeRepository.findById(typeId);

        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setName(modelDto.getName());
        modelEntity.setSerialNumber(modelDto.getSerialNumber());
        modelEntity.setColor(modelDto.getColor());
        modelEntity.setSize(modelDto.getSize());
        modelEntity.setPrice(modelDto.getPrice());
        modelEntity.setIsInStock(modelDto.getIsInStock());
        modelEntity.setTypeEntity(typeEntity.orElse(null));

        ModelEntity modelEntityCreated = modelRepository.saveAndFlush(modelEntity);

        List<ModelAttributeEntity> attForModelEntity = createModelAttForEntity(modelEntityCreated, modelDto.getModelAttributeDto());
        modelEntityCreated.setModelAttributeEntity(attForModelEntity);

        return modelEntityCreated;
    }

    private List<ModelAttributeEntity> createModelAttForEntity(ModelEntity modelEntityCreated,
                                                              List<ModelAttributeDto> modelAttributeDtoList) {

        List<ModelAttributeEntity> attributeEntityList = new ArrayList<>();

        for (ModelAttributeDto modelAttributeDto : modelAttributeDtoList) {

            ModelAttributeEntity modelAttributeEntity = new ModelAttributeEntity();

            modelAttributeEntity.setName(modelAttributeDto.getName());
            modelAttributeEntity.setValue(modelAttributeDto.getValue());
            modelAttributeEntity.setModelEntity(modelEntityCreated);
            attributeEntityList.add(modelAttributeEntity);
        }

        return modelAttributeRepository.saveAllAndFlush(attributeEntityList);
    }

}
