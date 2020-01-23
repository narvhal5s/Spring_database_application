package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddCustomerRequest {

    @NotNull
    private String name;

    @NotNull
    private String NIP;

    @NotNull
    private String city;

    @NotNull
    private String postal_code;

    @NotNull
    private String building_number;

    @NotNull
    private String street;


}
