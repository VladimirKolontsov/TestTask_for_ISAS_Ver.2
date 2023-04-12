package ru.kolontsov.testtask.TestTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "product_model")
public class ModelEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Min(value = 1)
    @Column(name = "serial_number")
    private Integer serialNumber;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private Integer size;

    @Min(value = 1)
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_in_stock")
    private Boolean isInStock;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @JsonIgnore
    private TypeEntity typeEntity;

    @OneToMany(mappedBy = "modelEntity")
    private List<ModelAttributeEntity> modelAttributeEntity;

}
