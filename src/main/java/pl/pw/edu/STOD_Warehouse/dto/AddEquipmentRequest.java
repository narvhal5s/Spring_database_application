package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddEquipmentRequest {

    @NotNull
    private String name;

    @NotNull
    private String year;

    @NotNull
    private String headquarterId;

}
