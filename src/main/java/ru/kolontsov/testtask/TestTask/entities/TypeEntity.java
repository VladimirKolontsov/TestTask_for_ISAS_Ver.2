package ru.kolontsov.testtask.TestTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "product_type")
@Schema(example = "Вид техники")
public class TypeEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Уникальный идентификатор")
    private Long id;

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

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @JsonIgnore
    private Types types;

    @OneToMany(mappedBy = "typeEntity")
    @Schema(name = "Модели данного типа")
    private List<ModelEntity> modelEntities;

}
