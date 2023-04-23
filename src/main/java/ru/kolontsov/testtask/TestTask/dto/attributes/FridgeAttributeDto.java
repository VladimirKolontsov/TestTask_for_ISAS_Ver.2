package ru.kolontsov.testtask.TestTask.dto.attributes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Fridge characteristics")
public class FridgeAttributeDto {

    @Schema(name = "Unique identifier")
    private Long modelId;

    @Schema(name = "Quantity of doors")
    private Integer quantityOfDoors;

    @Schema(name = "Type of compressor")
    private String typeOfCompressor;
}
