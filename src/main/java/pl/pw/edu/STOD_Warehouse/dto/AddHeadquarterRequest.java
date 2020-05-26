package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddHeadquarterRequest {

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String phoneNumber;

}
