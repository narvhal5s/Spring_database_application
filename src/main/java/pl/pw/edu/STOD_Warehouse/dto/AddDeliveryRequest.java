package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddDeliveryRequest {

    @NotNull
    private Long fk_product_id;

    @NotNull
    private Long fk_supplier_id;

    @NotNull
    private Long quantity;

    @NotNull
    private Double value;

    @NotNull
    private String date;


}
