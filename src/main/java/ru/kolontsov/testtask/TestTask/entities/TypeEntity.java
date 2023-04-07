package ru.kolontsov.testtask.TestTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "product_type")
public class TypeEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "brand")
    private String brand;

    @Column(name = "is_online_order")
    private Boolean isOnlineOrder;

    @Column(name = "is_credit")
    private Boolean isCredit;

    @Column(name = "is_in_stock")
    private Boolean isInStock;

//    @OneToMany(mappedBy = "typeEntity")
//    private List<ModelEntity> modelEntities;
}
