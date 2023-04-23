package ru.kolontsov.testtask.TestTask.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kolontsov.testtask.TestTask.dto.ModelDto;
import ru.kolontsov.testtask.TestTask.dto.TypeDto;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;
import ru.kolontsov.testtask.TestTask.entities.Types;
import ru.kolontsov.testtask.TestTask.enums.SortingType;
import ru.kolontsov.testtask.TestTask.services.ModelService;
import ru.kolontsov.testtask.TestTask.services.TypeEntityService;
import ru.kolontsov.testtask.TestTask.services.TypesService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@Tag(name = "Модели", description = "Методы для работы с моделями")
public class Controller {

    private final TypesService typesService;
    private final TypeEntityService typeEntityService;
    private final ModelService modelService;

    @Autowired
    public Controller(TypesService typesService, TypeEntityService typeEntityService, ModelService modelService) {
        this.typesService = typesService;
        this.typeEntityService = typeEntityService;
        this.modelService = modelService;
    }

    @GetMapping
    public String showMessage() {
        return "Let's start to chose technique for you!";
    }

    @GetMapping("/find")
    @Operation(summary = "all models")
    public List<Types> showAll() {
        return typesService.findAll();
    }

    //possible to write several names separated by space
    @GetMapping("/find/name/{name}")
    @Operation(summary = "models of the selected type of technique")
    public List<TypeEntity> showModelsByType(@Parameter(description = "Selected types of technique")
                                             @PathVariable("name") List<String> names) {
        return typeEntityService.findByTypesName(names);
    }

    //possible to write several colors separated by space
    @GetMapping("/find-color")
    @Operation(summary = "all models of selected color")
    public List<ModelEntity> showModelsByColor(@Parameter(description = "Selected colors")
                                               @RequestParam("color") List<String> colors) {
        return modelService.showModelByColor(colors);
    }

    @GetMapping("/find-price")
    @Operation(summary = "all models from that range of price")
    public List<ModelEntity> showModelsByPriceRange(@RequestParam("min") BigDecimal minPrice,
                                                    @RequestParam("max") BigDecimal maxPrice) {
        return modelService.showModelByPrice(minPrice, maxPrice);
    }

    @GetMapping("/find-stock")
    @Operation(summary = "all models is on stock")
    public List<ModelEntity> showModelInStock(@Parameter(description = "stock availability")
                                              @RequestParam("stock") boolean isInStock) {
        return modelService.showModelIsInStock(isInStock);
    }

    @GetMapping("/find-size")
    @Operation(summary = "all models of selected range of size")
    public List<ModelEntity> showModelBySize(@RequestParam("min") int min,
                                             @RequestParam("max") int max) {
        return modelService.showModelBySize(min, max);
    }

    @GetMapping("/sort-name")
    @Operation(summary = "all models sorted by name")
    public List<ModelEntity> sortByName(@Parameter(description = "stock availability")
                                        @RequestParam("stock") boolean isInStock,
                                        @Parameter(description = "sorting type")
                                        @RequestParam("sorting") SortingType sortingType) {
        List<ModelEntity> sortedModelList = new ArrayList<>();

        if (sortingType.equals(SortingType.ASC)) {
            sortedModelList = modelService.sortModelsByNameAsc(isInStock);
        } else if (sortingType.equals(SortingType.DESC)) {
            sortedModelList = modelService.sortModelsByNameDesc(isInStock);
        }

        return sortedModelList;
    }

    @GetMapping("/sort-price")
    @Operation(summary = "all models sorted by price")
    public List<ModelEntity> sortModelsByPrice(@Parameter(description = "stock availability")
                                               @RequestParam("stock") boolean isInStock,
                                               @Parameter(description = "sorting type")
                                               @RequestParam("sorting") SortingType sortingType) {

        List<ModelEntity> sortedModelList = new ArrayList<>();

        if (sortingType.equals(SortingType.ASC)) {
            sortedModelList = modelService.sortModelsByPriceAsc(isInStock);
        } else if (sortingType.equals(SortingType.DESC)) {
            sortedModelList = modelService.sortModelsByPriceDesc(isInStock);
        }

        return sortedModelList;
    }

    @PostMapping("/add-type")
    @Operation(summary = "add new overview for models")
    public void createNewTypeEntity(@Parameter(description = "Model overview parameters for adding")
                                    @RequestBody TypeDto typeDto) {
        typeEntityService.createNewModelEntityAndAddItToTypeEntity(typeDto);
    }

    @PostMapping("/add-model")
    @Operation(summary = "add new model")
    public void createNewTypeEntity(@Parameter(description = "Model parameters for adding")
                                    @RequestBody ModelDto modelDto) {
        modelService.createNewModelEntity(modelDto);
    }

}
