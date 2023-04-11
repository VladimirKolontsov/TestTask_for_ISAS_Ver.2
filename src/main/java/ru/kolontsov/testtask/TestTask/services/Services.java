package ru.kolontsov.testtask.TestTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import ru.kolontsov.testtask.TestTask.dto.ModelAttributeDto;
import ru.kolontsov.testtask.TestTask.dto.ModelDto;
import ru.kolontsov.testtask.TestTask.dto.TypeName;
import ru.kolontsov.testtask.TestTask.entities.ModelAttributeEntity;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.repositories.ModelAttributeRepository;
import ru.kolontsov.testtask.TestTask.repositories.ModelRepository;
import ru.kolontsov.testtask.TestTask.repositories.TypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public List<TypeEntity> findAll() { // работает, но наверное не нужен
        List<TypeEntity> entityList = typeRepository.findAll();
        return entityList;
    }

    public Optional<TypeEntity> findById(long id) { // работает, но по сути не нужен
        Optional<TypeEntity> typeRepositoryById = typeRepository.findById(id);
        return typeRepositoryById;
    }

    // Нахождение List<Long> typeIdList, чтоды использовать в других функциях -> пока не пригодилось, наверное удалю

//    public List<Long> getTypeIdList(String name) { // обошелся без него
//        List<Long> typeIdList = typeRepository.findAllByNameIgnoreCase(name).stream().
//                map(TypeEntity::getId).collect(Collectors.toList());
//        return typeIdList;
//    }

    // Фильтрация по виду техники: приходит название типа техники -> выходит список моделей этого типа
    public List<ModelEntity> getModelsByTypeName(List<String> names) { // работает

        List<ModelEntity> allModelsByProductTypeName = modelRepository.findAllByTypeEntityNameInIgnoreCase(names);
        return allModelsByProductTypeName;
    }

    // Фильтрация по виду техники и ее цвету: приходит тип техники и ее цвет -> выходит список моделей этого типа и цвета
    public List<ModelEntity> getModelsByColor(String color) { //работает
        List<ModelEntity> allModelsByColor =
                modelRepository.findAllByColorIgnoreCase(color);
        return allModelsByColor;
    }

    // Фильтрация по виду техники и диапазону цены: приходит тип техники и ценовой диапазон -> выходит список моделей этого типа и цены
    public List<ModelEntity> getModelsByRangeOfPrice (int minPrice, int maxPrice) { // работает

        List<ModelEntity> modelEntitiesByPriceBetween = modelRepository.findModelEntitiesByPriceBetween(minPrice, maxPrice);
//        List<ModelEntity> modelsByPriceAndTypeName = modelEntitiesByPriceBetween.stream()
//                .filter(m -> m.getTypeEntity().getName().equalsIgnoreCase(name))
//                .collect(Collectors.toList());

        return modelEntitiesByPriceBetween;
    }

    // Вывод моделей по типу техники со спец аттрибутами
    public List<ModelEntity> modelsAttribute(String typeName, String attName, String attValue) {
        List<ModelEntity> allByAttributes = modelRepository.findAllByAttributes(typeName, attName, attValue);
        return allByAttributes;
    }

    // Фильтр по типу техники и наличию на складе
    public List<ModelEntity> modelsByTypeNameAndStockAvailable(String typeName, boolean isInStock) {
        return modelRepository.findAllByTypeEntityNameIgnoreCaseAndAndIsInStock(typeName, isInStock);
    }

    // Фильтр по типу техники и размеру
    public List<ModelEntity> modelsByTypeNameAndSize(String typeName, int min, int max) {
        return modelRepository.findAllByTypeEntityNameIgnoreCaseAndSizeBetween(typeName, min, max);
    }

    // Сортировка по алфавиту: приходит тип техники -> модели этого типа техники отсортированные по имени моделей

    public List<ModelEntity> modelsSortByName(String name) { // работает
        List<ModelEntity> modelsSortByName = modelRepository.findAllByTypeEntityNameIgnoreCaseOrderByName(name);
        return modelsSortByName;
    }
    // Сортировка по алфавиту: приходит тип техники -> модели этого типа техники отсортированные по имени моделей по убыванию

    public List<ModelEntity> modelsSortByNameDesc(String name) { // работает
        List<ModelEntity> modelsSortByName = modelRepository.findAllByTypeEntityNameIgnoreCaseOrderByNameDesc(name);
        return modelsSortByName;
    }
    // Сортировка по цене: приходит тип техники -> модели этого типа техники отсортированные по цене

    public List<ModelEntity> modelsSortByPrice(String name) {
        List<ModelEntity> modelsSortByName = modelRepository.findAllByTypeEntityNameIgnoreCaseOrderByPrice(name);
        return modelsSortByName;
    }
    // Сортировка по цене: приходит тип техники -> модели этого типа техники отсортированные по цене по убыванию

    public List<ModelEntity> modelsSortByPriceDesc(String name) {
        List<ModelEntity> modelsSortByName = modelRepository.findAllByTypeEntityNameIgnoreCaseOrderByPriceDesc(name);
        return modelsSortByName;
    }

    @Transactional
    public ModelEntity createNewModelEntity(ModelDto modelDto,
                                            ModelAttributeDto modelAttributeDto) {

        Long typeId = modelDto.getTypeId();//выцепили в какой вид техники мы хотим добавить - id
        Optional<TypeEntity> typeEntity = typeRepository.findById(typeId);// по этому id ищем сам объект типа техники

        List<ModelAttributeEntity> attForModelEntity = createModelAttForEntity(modelDto, modelAttributeDto);

        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setName(modelDto.getName());
        modelEntity.setSerialNumber(modelDto.getSerialNumber());
        modelEntity.setColor(modelDto.getColor());
        modelEntity.setSize(modelDto.getSize());
        modelEntity.setPrice(modelDto.getPrice());
        modelEntity.setIsInStock(modelDto.getIsInStock());
        modelEntity.setTypeEntity(typeEntity.orElse(null));
        modelEntity.setModelAttributeEntity(attForModelEntity);

        //сохранить в переменную и ее добавляю в attribute entity -> пока не понятно как это поможет
        ModelEntity modelEntityCreated = modelRepository.saveAndFlush(modelEntity);
        return modelEntityCreated;
    }

    @Transactional
    public List<ModelAttributeEntity> createModelAttForEntity(ModelDto modelDto,
                                                              ModelAttributeDto modelAttributeDto) {

        Long typeId = modelDto.getTypeId();
        String typeName = Objects.requireNonNull(typeRepository.findById(typeId).orElse(null)).getName();

        List<ModelAttributeEntity> attributeEntityList = new ArrayList<>();
        ModelAttributeEntity modelAttribute1 = new ModelAttributeEntity();
        ModelAttributeEntity modelAttribute2 = new ModelAttributeEntity();

        if (typeName.equalsIgnoreCase(String.valueOf(TypeName.TV))) {

            modelAttribute1.setName("category");
            modelAttribute1.setValue(modelAttributeDto.getValue());

            modelAttribute2.setName("technology");
            modelAttribute2.setValue(modelAttributeDto.getValue());
        } // и так далее для всех типов техники

        attributeEntityList.add(modelAttribute1);
        attributeEntityList.add(modelAttribute2);
        modelAttributeRepository.saveAllAndFlush(attributeEntityList);
        return attributeEntityList;
    }



}
