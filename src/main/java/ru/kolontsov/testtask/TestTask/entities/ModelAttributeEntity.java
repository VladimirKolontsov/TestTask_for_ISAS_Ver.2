package ru.kolontsov.testtask.TestTask.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "product_model_attribute")
public class ModelAttributeEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "product_model_id")
//    private Long productModelId;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    private ModelEntity modelEntity;

}
