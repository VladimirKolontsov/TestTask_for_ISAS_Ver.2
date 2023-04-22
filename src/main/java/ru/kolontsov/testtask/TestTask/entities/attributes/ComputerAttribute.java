package ru.kolontsov.testtask.TestTask.entities.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

@Getter
@Setter
@Entity
@Table(name = "computer_attribute")
public class ComputerAttribute {
    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long productModelId;

    private String categories;

    private String typeOfProcessor;

    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    @JsonIgnore
    private ModelEntity modelEntity;
}
