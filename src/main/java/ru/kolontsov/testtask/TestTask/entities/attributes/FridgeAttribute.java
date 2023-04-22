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
@Table(name = "fridge_attribute")
public class FridgeAttribute {
    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long productModelId;

    private Integer quantityOfDoors;

    private String typeOfCompressor;

    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    @JsonIgnore
    private ModelEntity modelEntity;
}
