package ru.kolontsov.testtask.TestTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(name = "Модель")
public class ModelDto {

    @Schema(name = "Идентификатор типа техники")
    private Long typeId;

    @Schema(name = "Наименование модели")
    private String name;

    @Schema(name = "Серийный номер")
    private Integer serialNumber;

    @Schema(name = "Цвет")
    private String color;

    @Schema(name = "Размер")
    private Integer size;

    @Schema(name = "Цена")
    private BigDecimal price;

    @Schema(name = "Наличие на складе")
    private Boolean isInStock;

    @Schema(name = "Уникальные характеристики")
    private List<ModelAttributeDto> modelAttributeDto;

}
