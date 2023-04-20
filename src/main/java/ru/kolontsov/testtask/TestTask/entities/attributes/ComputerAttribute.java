package ru.kolontsov.testtask.TestTask.entities.attributes;

import jakarta.persistence.*;
import lombok.Data;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

@Data
@Entity
@Table(name = "computer_attribute")
public class ComputerAttribute {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long productModelId;

    private String categories;

    private String typeOfProcessor;

    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    private ModelEntity computerModel;
}
