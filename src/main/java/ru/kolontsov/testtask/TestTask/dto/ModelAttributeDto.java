package ru.kolontsov.testtask.TestTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Атрибуты модели")
public class ModelAttributeDto {

    @Schema(name = "Название характеристики")
    private String name;

    @Schema(name = "Значение характеристики")
    private String value;

}
