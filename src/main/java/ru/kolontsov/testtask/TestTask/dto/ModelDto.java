package ru.kolontsov.testtask.TestTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(name = "Модель")
public class ModelDto {

    private Long typeId;

    @Schema(name = "Наименование")
    private String name;

    @Schema(name = "Серийный номер")
    private Integer serialNumber;

    @Schema(name = "Цвет")
    private String color;

    @Schema(name = "Размер")
    private Integer size;

    @Schema(name = "Цена")
    private BigDecimal price;

    @Schema(name = "Налчие на складе")
    private Boolean isInStock;

    @Schema(name = "Уникальные характеристики")
    private List<ModelAttributeDto> modelAttributeDto;

}
