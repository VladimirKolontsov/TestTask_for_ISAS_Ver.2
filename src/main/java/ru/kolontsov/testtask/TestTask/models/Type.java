package ru.kolontsov.testtask.TestTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_type")
public class Type {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "country")
    private String country;

    @NotEmpty
    @Column(name = "brand")
    private String brand;

    @NotEmpty
    @Column(name = "is_online_order")
    private boolean isOnlineOrder;

    @NotEmpty
    @Column(name = "is_credit")
    private boolean isCredit;

    @NotEmpty
    @Column(name = "is_in_stock")
    private boolean isInStock;

    @OneToMany(mappedBy = "type")
    private List<Model> models;
}
