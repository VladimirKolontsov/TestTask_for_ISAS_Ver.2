package ru.kolontsov.testtask.TestTask.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kolontsov.testtask.TestTask.dto.ModelDto;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.services.Services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "Модели", description = "Методы для работы с моделями")
public class Controller {

    private final Services services;

    @Autowired
    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping
    public String showMessage() {
        return "Let's start to chose technique for you!";
    }

    @GetMapping("/find")
    @Operation(summary = "все модели реестра")
    public List<TypeEntity> showAll() {
        return services.findAll();
    }

    // можно передать в запрос лист разных имен
    @GetMapping("/find/name/{name}")
    @Operation(summary = "модели выбранного типа техники")
    public List<ModelEntity> showModelsByType(
                                            @Parameter(description = "выбранный тип техники")
                                            @PathVariable("name") List<String> names) {
        return services.getModelsByTypeName(names);
    }

    @GetMapping("/find-color")
    @Operation(summary = "модели выбранного цвета техники")
    public List<ModelEntity> showModelsByColor(@Parameter(description = "выбранный цвет техники")
                                                      @RequestParam("color") List<String> color) {
        return services.getModelsByColor(color);
    }

    @GetMapping("/find-price")
    @Operation(summary = "модели выбранного ценового диапазона")
    public List<ModelEntity> showModelsByPriceRange(@RequestParam("min") BigDecimal minPrice,
                                                    @RequestParam("max") BigDecimal maxPrice) {
        return services.getModelsByRangeOfPrice(minPrice, maxPrice);
    }

    @GetMapping("/find-att")
    @Operation(summary = "модели выбранного типа техники и его уникальных атрибутов")
    public List<ModelEntity> showModelAttribute(@Parameter(description = "выбранный тип техники")
                                                @RequestParam("name") String name,
                                                @Parameter(description = "название характеристики")
                                                @RequestParam("attname") String attName,
                                                @Parameter(description = "значение характеристики")
                                                @RequestParam("attvalue") String attValue) {
        return services.modelsAttribute(name, attName, attValue);
    }

    @GetMapping("/find-stock")
    @Operation(summary = "модели техники в наличии")
    public List<ModelEntity> showModelByTypeAndInStock(@Parameter(description = "выбранные типы техники")
                                                       @RequestParam("name") List<String> name,
                                                       @Parameter(description = "наличие на складе")
                                                       @RequestParam("stock") boolean isInStock) {
        return services.modelsByTypeNameAndStockAvailable(name, isInStock);
    }

    @GetMapping("/find-size")
    @Operation(summary = "модели выбранного типа техники и размера")
    public List<ModelEntity> showModelByTypeAndSize(@Parameter(description = "выбранные типы техники")
                                                    @RequestParam("name") List<String> name,
                                                    @RequestParam("min") int min,
                                                    @RequestParam("max") int max) {
        return services.modelsByTypeNameAndSize(name, min, max);
    }

    @GetMapping("/sort")
    @Operation(summary = "сортировка моделей по имени")
    public List<ModelEntity> sortModelsByName(@RequestParam("name") String typeName,
                                              @RequestParam("sorting") String sortingType) {

        List<ModelEntity> sortedModelList = new ArrayList<>();

        if (sortingType.equalsIgnoreCase(String.valueOf(SortingType.ASC))) {
            sortedModelList = services.modelsSortByName(typeName);
        } else if (sortingType.equalsIgnoreCase(String.valueOf(SortingType.DESC))) {
            sortedModelList = services.modelsSortByNameDesc(typeName);
        }

        return sortedModelList;
    }

    @GetMapping("/sort-price")
    @Operation(summary = "сортировка моделей по цене")
    public List<ModelEntity> sortModelsByPrice(@RequestParam("name") String typeName,
                                              @RequestParam("sorting") String sortingType) {

        List<ModelEntity> sortedModelList = new ArrayList<>();

        if (sortingType.equalsIgnoreCase(String.valueOf(SortingType.ASC))) {
            sortedModelList = services.modelsSortByPrice(typeName);
        } else if (sortingType.equalsIgnoreCase(String.valueOf(SortingType.DESC))) {
            sortedModelList = services.modelsSortByPriceDesc(typeName);
        }

        return sortedModelList;
    }

    @PostMapping("/add")
    @Operation(summary = "добавление новой модели")
    public void createNewTypeEntity(@Parameter(description = "значения новой модели для добавления")
                                      @RequestBody ModelDto modelDto) {

        services.createNewModelEntity(modelDto);
    }

}
