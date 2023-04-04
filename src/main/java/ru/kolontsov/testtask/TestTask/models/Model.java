package ru.kolontsov.testtask.TestTask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_model")
public class Model {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "product_type_id")
    private int productTypeId;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Min(value = 1)
    @Column(name = "serial_number")
    private int serialNumber;

    @NotEmpty
    @Column(name = "color")
    private String color;

    @NotEmpty
    @Column(name = "size")
    private String size;

    @NotEmpty
    @Min(value = 1)
    @Column(name = "price")
    private int price;

    @NotEmpty
    @Column(name = "is_in_stock")
    private boolean isInStock;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    private Type type;

    @NotEmpty
    @OneToOne(mappedBy = "model")
    private ModelAttribute modelAttribute;
}
