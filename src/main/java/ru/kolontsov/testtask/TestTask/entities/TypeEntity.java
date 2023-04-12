package ru.kolontsov.testtask.TestTask.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "product_type")
@Schema(name = "Вид техники")
public class TypeEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Уникальный идентификатор")
    private Long id;

    @Column(name = "name")
    @Schema(name = "Название вида техники")
    private String name;

    @Column(name = "country")
    @Schema(name = "Страна производитель")
    private String country;

    @Column(name = "brand")
    @Schema(name = "Бренд")
    private String brand;

    @Column(name = "is_online_order")
    @Schema(name = "Возможность заказа онлайн")
    private Boolean isOnlineOrder;

    @Column(name = "is_credit")
    @Schema(name = "Возможность покупки в кредит")
    private Boolean isCredit;

    @Column(name = "is_in_stock")
    @Schema(name = "Наличие на складе")
    private Boolean isInStock;

    @OneToMany(mappedBy = "typeEntity")
    @Schema(name = "Модели данного типа")
    private List<ModelEntity> modelEntities;

    //TODO нах эти конструкторы делал тоже не помню) закоменитл - вроде пока все работает.
//    public TypeEntity(String name, String country, String brand,
//                      Boolean isOnlineOrder, Boolean isCredit, Boolean isInStock) {
//        this.name = name;
//        this.country = country;
//        this.brand = brand;
//        this.isOnlineOrder = isOnlineOrder;
//        this.isCredit = isCredit;
//        this.isInStock = isInStock;
//    }
//
//    public TypeEntity() {
//    }
}
