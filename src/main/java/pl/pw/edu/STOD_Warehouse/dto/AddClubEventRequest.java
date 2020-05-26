package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddClubEventRequest {

    @NotNull
    private String name;

    @NotNull
    private String headquarterId;

}
