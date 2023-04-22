package ru.kolontsov.testtask.TestTask.services;

import org.springframework.stereotype.Service;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.repositories.ModelRepository;
import ru.kolontsov.testtask.TestTask.repositories.TypeRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ModelService {
    private final ModelRepository modelRepository;
    private final TypeRepository typeRepository;

    public ModelService(ModelRepository modelRepository, TypeRepository typeRepository) {
        this.modelRepository = modelRepository;
        this.typeRepository = typeRepository;
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
}
