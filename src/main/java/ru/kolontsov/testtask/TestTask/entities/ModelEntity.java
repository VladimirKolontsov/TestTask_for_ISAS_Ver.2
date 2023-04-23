package ru.kolontsov.testtask.TestTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import ru.kolontsov.testtask.TestTask.entities.attributes.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product_model")
@Schema(example = "Model")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Unique identifier")
    private Long id;

    @Schema(name = "Name of model")
    private String name;

    @Min(value = 1)
    @Schema(name = "Serial number")
    private Integer serialNumber;

    @Schema(name = "Color")
    private String color;

    @Schema(name = "Size")
    private Integer size;

    @Min(value = 1)
    @Schema(name = "Price")
    private BigDecimal price;

    @Schema(name = "Stock availability")
    private Boolean isInStock;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @JsonIgnore
    private TypeEntity typeEntity;


    @OneToOne(mappedBy = "modelEntity")
    @Schema(name = "TV attributes")
    private TvAttribute tvAttribute;

    @OneToOne(mappedBy = "modelEntity")
    @Schema(name = "Cleaner attributes")
    private CleanerAttribute cleanerAttribute;

    @OneToOne(mappedBy = "modelEntity")
    @Schema(name = "Fridge attributes")
    private FridgeAttribute fridgeAttribute;

    @OneToOne(mappedBy = "modelEntity")
    @Schema(name = "Phone attributes")
    private PhoneAttribute phoneAttribute;

    @OneToOne(mappedBy = "modelEntity")
    @Schema(name = "Computer attributes")
    private ComputerAttribute computerAttribute;

}
