package ru.kolontsov.testtask.TestTask.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Data;
import ru.kolontsov.testtask.TestTask.entities.ModelAttributeEntity;
import ru.kolontsov.testtask.TestTask.entities.TypeEntity;

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

    //TODO переделать на BigDecimalт или все таки Double?
    @Schema(name = "Цена")
    private Integer price;

    @Schema(name = "Налчие на складе")
    private Boolean isInStock;

//    @Schema(name = "Уникальные характеристики")
//    private List<ModelAttributeDto> modelAttributeDto;

}
