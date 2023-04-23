package ru.kolontsov.testtask.TestTask.dto.attributes;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Computer characteristics")
public class ComputerAttributeDto {

    @Schema(name = "Unique identifier")
    private Long modelId;

    @Schema(name = "Category")
    private String categories;

    @Schema(name = "Type of processor")
    private String typeOfProcessor;
}
