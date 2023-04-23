package ru.kolontsov.testtask.TestTask.dto.attributes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Cleaner characteristics")
public class CleanerAttributeDto {

    @Schema(name = "Unique identifier")
    private Long modelId;

    @Schema(name = "Dust container volume")
    private Double dustContainerVolume;

    @Schema(name = "Quantity of modes")
    private Integer quantityOfModes;
}
