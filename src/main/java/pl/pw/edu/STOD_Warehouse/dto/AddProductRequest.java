package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddProductRequest {

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Long quantity;

    @NotNull
    private String manufacturer;

}
