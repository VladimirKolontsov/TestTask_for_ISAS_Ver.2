package ru.kolontsov.testtask.TestTask.entities.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

@Getter
@Setter
@Entity
@Table(name = "cleaner_attribute")
@Schema(example = "Cleaner attribute")
public class CleanerAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Unique identifier")
    private Long id;

    @Schema(name = "Dust container volume")
    private Double dustContainerVolume;

    @Schema(name = "quantity of modes")
    private Integer quantityOfModes;

    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    @JsonIgnore
    private ModelEntity modelEntity;
}
