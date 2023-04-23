package ru.kolontsov.testtask.TestTask.entities.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

@Getter
@Setter
@Entity
@Table(name = "phone_attribute")
@Schema(example = "Phone attribute")
public class PhoneAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Unique identifier")
    private Long id;

    @Schema(name = "Phone memory")
    private Integer phoneMemory;

    @Schema(name = "Quantity of cameras")
    private Integer quantityOfCameras;

    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    @JsonIgnore
    private ModelEntity modelEntity;
}
