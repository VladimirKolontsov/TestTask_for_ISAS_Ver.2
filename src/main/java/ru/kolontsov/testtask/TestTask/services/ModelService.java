package ru.kolontsov.testtask.TestTask.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kolontsov.testtask.TestTask.dto.ModelDto;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.entities.attributes.*;
import ru.kolontsov.testtask.TestTask.enums.Type;
import ru.kolontsov.testtask.TestTask.repositories.ModelRepository;
import ru.kolontsov.testtask.TestTask.repositories.TypeRepository;
import ru.kolontsov.testtask.TestTask.repositories.attributes.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    private final ModelRepository modelRepository;
    private final TypeRepository typeRepository;
    private final ComputerAttributeRepository computerAttributeRepository;
    private final PhoneAttributeRepository phoneAttributeRepository;
    private final FridgeAttributeRepository fridgeAttributeRepository;
    private final TvAttributeRepository tvAttributeRepository;
    private final CleanerAttributeRepository cleanerAttributeRepository;

    public ModelService(ModelRepository modelRepository, TypeRepository typeRepository, ComputerAttributeRepository computerAttributeRepository, PhoneAttributeRepository phoneAttributeRepository, FridgeAttributeRepository fridgeAttributeRepository, TvAttributeRepository tvAttributeRepository, CleanerAttributeRepository cleanerAttributeRepository) {
        this.modelRepository = modelRepository;
        this.typeRepository = typeRepository;
        this.computerAttributeRepository = computerAttributeRepository;
        this.phoneAttributeRepository = phoneAttributeRepository;
        this.fridgeAttributeRepository = fridgeAttributeRepository;
        this.tvAttributeRepository = tvAttributeRepository;
        this.cleanerAttributeRepository = cleanerAttributeRepository;
    }

    public List<ModelEntity> showModelByColor(List<String> colors) {
        return modelRepository.findAllByColorInIgnoreCase(colors);
    }

    public List<ModelEntity> showModelByPrice(BigDecimal min, BigDecimal max) {
        return modelRepository.findModelEntitiesByPriceBetween(min, max);
    }

    public List<ModelEntity> showModelIsInStock(boolean isInStock) {
        return modelRepository.findAllByIsInStock(isInStock);
    }

    public List<ModelEntity> showModelBySize(int min, int max) {
        return modelRepository.findAllBySizeBetween(min, max);
    }

    public List<ModelEntity> sortModelsByNameAsc(boolean isInStock) {
        return modelRepository.findAllByIsInStockOrderByNameAsc(isInStock);
    }

    public List<ModelEntity> sortModelsByNameDesc(boolean isInStock) {
        return modelRepository.findAllByIsInStockOrderByNameDesc(isInStock);
    }

    public List<ModelEntity> sortModelsByPriceAsc(boolean isInStock) {
        return modelRepository.findAllByIsInStockOrderByPriceAsc(isInStock);
    }

    public List<ModelEntity> sortModelsByPriceDesc(boolean isInStock) {
        return modelRepository.findAllByIsInStockOrderByPriceDesc(isInStock);
    }

    @Transactional
    public ModelEntity createNewModelEntity(ModelDto modelDto) {

        Long typeId = modelDto.getProductTypeId();
        Optional<TypeEntity> typeEntityOptional = typeRepository.findById(typeId);

        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setName(modelDto.getName());
        modelEntity.setSerialNumber(modelDto.getSerialNumber());
        modelEntity.setColor(modelDto.getColor());
        modelEntity.setSize(modelDto.getSize());
        modelEntity.setPrice(modelDto.getPrice());
        modelEntity.setIsInStock(modelDto.getIsInStock());


        if (typeEntityOptional.isPresent()) {
            TypeEntity typeEntity = typeEntityOptional.get();
            modelEntity.setTypeEntity(typeEntity);

            modelRepository.save(modelEntity);

            Type type = Type.valueOf(typeEntity.getTypes().getName().toUpperCase());

            switch (type) {
                case TV:
                    TvAttribute tvAttribute = new TvAttribute();
                    tvAttribute.setCategories(modelDto.getTvAttributeDto().getCategories());
                    tvAttribute.setTechnology(modelDto.getTvAttributeDto().getTechnology());
                    tvAttribute.setModelEntity(modelEntity);
                    tvAttributeRepository.saveAndFlush(tvAttribute);
                    modelEntity.setTvAttribute(tvAttribute);
                    break;
                case CLEANER:
                    CleanerAttribute cleanerAttribute = new CleanerAttribute();
                    cleanerAttribute.setDustContainerVolume(modelDto.getCleanerAttributeDto().getDustContainerVolume());
                    cleanerAttribute.setQuantityOfModes(modelDto.getCleanerAttributeDto().getQuantityOfModes());
                    cleanerAttribute.setModelEntity(modelEntity);
                    cleanerAttributeRepository.saveAndFlush(cleanerAttribute);
                    modelEntity.setCleanerAttribute(cleanerAttribute);
                    break;
                case FRIDGE:
                    FridgeAttribute fridgeAttribute = new FridgeAttribute();
                    fridgeAttribute.setQuantityOfDoors(modelDto.getFridgeAttributeDto().getQuantityOfDoors());
                    fridgeAttribute.setTypeOfCompressor(modelDto.getFridgeAttributeDto().getTypeOfCompressor());
                    fridgeAttribute.setModelEntity(modelEntity);
                    fridgeAttributeRepository.saveAndFlush(fridgeAttribute);
                    modelEntity.setFridgeAttribute(fridgeAttribute);
                    break;
                case PHONE:
                    PhoneAttribute phoneAttribute = new PhoneAttribute();
                    phoneAttribute.setPhoneMemory(modelDto.getPhoneAttributeDto().getPhoneMemory());
                    phoneAttribute.setQuantityOfCameras(modelDto.getPhoneAttributeDto().getQuantityOfCameras());
                    phoneAttribute.setModelEntity(modelEntity);
                    phoneAttributeRepository.saveAndFlush(phoneAttribute);
                    modelEntity.setPhoneAttribute(phoneAttribute);
                    break;
                case COMPUTER:
                    ComputerAttribute computerAttribute = new ComputerAttribute();
                    computerAttribute.setCategories(modelDto.getComputerAttributeDto().getCategories());
                    computerAttribute.setTypeOfProcessor(modelDto.getComputerAttributeDto().getTypeOfProcessor());
                    computerAttribute.setModelEntity(modelEntity);
                    computerAttributeRepository.saveAndFlush(computerAttribute);
                    modelEntity.setComputerAttribute(computerAttribute);
                    break;
                default: break;
            }
        }

        return modelEntity;
    }

}
