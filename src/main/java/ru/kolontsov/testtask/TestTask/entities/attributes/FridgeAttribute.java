package ru.kolontsov.testtask.TestTask.entities.attributes;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

@Data
@Entity
@Table(name = "fridge_attribute")
public class FridgeAttribute {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long productModelId;

    private Integer quantityOfDoors;

    private String typeOfCompressor;

    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    private ModelEntity fridgeModel;
}
