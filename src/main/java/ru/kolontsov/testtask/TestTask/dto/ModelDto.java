package ru.kolontsov.testtask.TestTask.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import ru.kolontsov.testtask.TestTask.dto.attributes.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Schema(name = "Model")
public class ModelDto {

    @Schema(name = "Unique identifier of product type")
    private Long productTypeId;

    @Schema(name = "Name of model")
    private String name;

    @Schema(name = "Serial number")
    private Integer serialNumber;

    @Schema(name = "Color")
    private String color;

    @Schema(name = "Size")
    private Integer size;

    @Schema(name = "Price")
    private BigDecimal price;

    @Schema(name = "Stock availability")
    private Boolean isInStock;

    @Schema(name = "Tv characteristics")
    private TvAttributeDto tvAttributeDto;

    @Schema(name = "Cleaner characteristics")
    private CleanerAttributeDto cleanerAttributeDto;

    @Schema(name = "Fridge characteristics")
    private FridgeAttributeDto fridgeAttributeDto;

    @Schema(name = "Phone characteristics")
    private PhoneAttributeDto phoneAttributeDto;

    @Schema(name = "Computer characteristics")
    private ComputerAttributeDto computerAttributeDto;

}
