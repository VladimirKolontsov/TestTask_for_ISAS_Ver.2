package ru.kolontsov.testtask.TestTask.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kolontsov.testtask.TestTask.dto.ModelAndAttributeDto;
import ru.kolontsov.testtask.TestTask.dto.ModelAttributeDto;
import ru.kolontsov.testtask.TestTask.dto.ModelDto;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.services.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@Tag(name = "Модели", description = "модели данного типа")
public class Controller {

    private final Services services;

    @Autowired
    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping
    public String showMessage() {
        return "my proj";
    }

    @GetMapping("/find")
    @Operation(summary = "все модели реестра")
    public List<TypeEntity> showAll() {
        return services.findAll();
    }

//    @GetMapping("/find/{id}")
//    public Optional<TypeEntity> findTypeById(@PathVariable("id") Long id) {
//        return services.findById(id);
//    }

    @GetMapping("/find/name/{name}")
    @Operation(summary = "модели выбранного типа техники")
    public List<ModelEntity> showModelsByType(
                                            @Parameter(description = "выбранный тип техники")
                                            @PathVariable("name") List<String> names) {
        return services.getModelsByTypeName(names);
    }

    //TODO как на лист поменять понятно, а как запрос сделать с листом в репозитории не понятно..
    @GetMapping("/find-color")
    @Operation(summary = "модели выбранного цвета техники")
    public List<ModelEntity> showModelsByTypeAndColor(@Parameter(description = "выбранный цвет техники")
                                                      @RequestParam("color") List<String> color) {
        return services.getModelsByColor(color);
    }

    @GetMapping("/find-price")
    @Operation(summary = "модели выбранного ценового диапазона")
    public List<ModelEntity> showModelsByPriceRange(@RequestParam("min") int minPrice,
                                                    @RequestParam("max") int maxPrice) {
        return services.getModelsByRangeOfPrice(minPrice, maxPrice);
    }

    //TODO не понял к чем этот метод
    @GetMapping("/find-att")
    public List<ModelEntity> showModelAttribute(@RequestParam("name") String name,
                                                @RequestParam("attname") String attName,
                                                @RequestParam("attvalue") String attValue) {
        return services.modelsAttribute(name, attName, attValue);
    }

    @GetMapping("/find-stock")
    @Operation(summary = "модели техники в наличии")
    public List<ModelEntity> showModelByTypeAndInStock(@RequestParam("name") List<String> name,
                                                       @RequestParam("stock") boolean isInStock) {
        return services.modelsByTypeNameAndStockAvailable(name, isInStock);
    }

    @GetMapping("/find-size")
    @Operation(summary = "модели выбранного типа техники и размера")
    public List<ModelEntity> showModelByTypeAndSize(@RequestParam("name") List<String> name,
                                                       @RequestParam("min") int min,
                                                    @RequestParam("max") int max) {
        return services.modelsByTypeNameAndSize(name, min, max);
    }

    //TODO есть смысл имя типа на Лист тоже переделать? и в цене соответственно тоже
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
    public String createNewTypeEntity(@RequestBody ModelDto modelDto) {

        services.createNewModelEntity(modelDto);

        return "redirect:/find";
    }

}
