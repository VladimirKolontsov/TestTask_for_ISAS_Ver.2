package ru.kolontsov.testtask.TestTask.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

@Data
@Schema(name = "Атрибуты модели")
public class ModelAttributeDto {

    @Schema(name = "Название характеристики")
    private String name;

    @Schema(name = "Значение характеристики")
    private String value;

}
