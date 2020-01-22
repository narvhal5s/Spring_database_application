package pl.pw.edu.STOD_Warehouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tokens")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidToken {

    public ValidToken(String token){
        this.token = token;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String token;

}
