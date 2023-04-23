package ru.kolontsov.testtask.TestTask.dto.attributes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Phone characteristics")
public class PhoneAttributeDto {
    @Schema(name = "Unique identifier")
    private Long modelId;

    @Schema(name = "Phone memory")
    private Integer phoneMemory;

    @Schema(name = "Quantity of cameras")
    private Integer quantityOfCameras;
}
