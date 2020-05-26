package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddEventMemberRequest {

    @NotNull
    private Long memberId;

    @NotNull
    private Long clubeventId;

}
