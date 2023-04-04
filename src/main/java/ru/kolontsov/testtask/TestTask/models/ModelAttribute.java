package ru.kolontsov.testtask.TestTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_model_attribute")
public class ModelAttribute {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "product_model_id")
    private int productModelId;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "value")
    private String value;

    @NotEmpty
    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    private Model model;

}
