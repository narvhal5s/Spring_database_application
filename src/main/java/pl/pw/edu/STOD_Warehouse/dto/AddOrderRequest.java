package pl.pw.edu.STOD_Warehouse.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddOrderRequest {


    @NotNull
    private Long fk_product_id;

    @NotNull
    private Long fk_customer_id;

    @NotNull
    private Long quantity;

}
