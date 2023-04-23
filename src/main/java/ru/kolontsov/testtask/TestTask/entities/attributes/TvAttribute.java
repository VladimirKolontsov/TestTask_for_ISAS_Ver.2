package ru.kolontsov.testtask.TestTask.entities.attributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.kolontsov.testtask.TestTask.entities.ModelEntity;

@Getter
@Setter
@Entity
@Table(name = "tv_attribute")
@Schema(example = "Tv attribute")
public class TvAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name = "Unique identifier")
    private Long id;

    @Schema(name = "Category")
    private String categories;

    @Schema(name = "Technology")
    private String technology;

    @OneToOne
    @JoinColumn(name = "product_model_id", referencedColumnName = "id")
    @JsonIgnore
    private ModelEntity modelEntity;
}
