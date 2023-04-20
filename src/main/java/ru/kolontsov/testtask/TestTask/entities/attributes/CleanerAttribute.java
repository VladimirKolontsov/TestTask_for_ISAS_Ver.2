package ru.kolontsov.testtask.TestTask.entities.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

@Data
@Entity
@Table(name = "cleaner_attribute")
public class CleanerAttribute {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Уникальный идентификатор характеристики")
    private Long id;

//    private Long productModelId;

    private Double dustContainerVolume;

    private Integer quantityOfModes;

    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    @JsonIgnore
    private ModelEntity cleanerModel;
}
