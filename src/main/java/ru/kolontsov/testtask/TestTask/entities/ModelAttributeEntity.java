package ru.kolontsov.testtask.TestTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "product_model_attribute")
@Schema(example = "Атрибуты модели")
public class ModelAttributeEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Уникальный идентификатор характеристики")
    private Long id;

    @Column(name = "name")
    @Schema(name = "Название характеристики")
    private String name;

    @Column(name = "value")
    @Schema(name = "Значение характеристики")
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    @JsonIgnore
    private ModelEntity modelEntity;

}
