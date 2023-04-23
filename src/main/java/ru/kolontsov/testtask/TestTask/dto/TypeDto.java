package ru.kolontsov.testtask.TestTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Model overview")
public class TypeDto {

    @Schema(name = "Unique identifier of type technique")
    private Long typesId;

    @Schema(name = "Country producer")
    private String country;

    @Schema(name = "Brand")
    private String brand;

    @Schema(name = "Online order availability")
    private Boolean isOnlineOrder;

    @Schema(name = "Availability to buy in credit")
    private Boolean isCredit;

    private ModelDto modelDto;
}
