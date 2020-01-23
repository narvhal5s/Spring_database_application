package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddSupplierRequest {


    @NotNull
    private String name;

    @NotNull
    private Double quality;

}
