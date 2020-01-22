package pl.pw.edu.STOD_Warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
