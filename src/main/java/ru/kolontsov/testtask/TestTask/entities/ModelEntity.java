package ru.kolontsov.testtask.TestTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import ru.kolontsov.testtask.TestTask.entities.attributes.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product_model")
@Schema(example = "Модель")
public class ModelEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Уникальный идентификатор")
    private Long id;

    @Column(name = "name")
    @Schema(name = "Наименование модели")
    private String name;

    @Min(value = 1)
    @Column(name = "serial_number")
    @Schema(name = "Серийный номер")
    private Integer serialNumber;

    @Column(name = "color")
    @Schema(name = "Цвет")
    private String color;

    @Column(name = "size")
    @Schema(name = "Размер")
    private Integer size;

    @Min(value = 1)
    @Column(name = "price")
    @Schema(name = "Цена")
    private BigDecimal price;

    @Column(name = "is_in_stock")
    @Schema(name = "Налчие на складе")
    private Boolean isInStock;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @JsonIgnore
    private TypeEntity typeEntity;

//    @OneToOne(mappedBy = "modelEntity")
//    private TvAttribute tvAttribute;
//
//    @OneToOne(mappedBy = "modelEntity")
//    private CleanerAttribute cleanerAttribute;
//
//    @OneToOne(mappedBy = "modelEntity")
//    private FridgeAttribute fridgeAttribute;
//
//    @OneToOne(mappedBy = "modelEntity")
//    private PhoneAttribute phoneAttribute;
//
//    @OneToOne(mappedBy = "modelEntity")
//    private ComputerAttribute computerAttribute;

}
