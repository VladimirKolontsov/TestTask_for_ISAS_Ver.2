package ru.kolontsov.testtask.TestTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_type")
@Schema(example = "Model overview")
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Unique identifier")
    private Long id;

    @Schema(name = "Country producer")
    private String country;

    @Schema(name = "Brand")
    private String brand;

    @Schema(name = "Online order availability")
    private Boolean isOnlineOrder;

    @Schema(name = "availability to buy in credit")
    private Boolean isCredit;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @JsonIgnore
    private Types types;

    @OneToMany(mappedBy = "typeEntity")
    @Schema(name = "Model of this type and brand")
    private Set<ModelEntity> modelEntities;

}
