package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddClubMemberRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String address;

    @NotNull
    private String city;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private Long headquarterId;

    @NotNull
    private Boolean contributionPaid;

}
