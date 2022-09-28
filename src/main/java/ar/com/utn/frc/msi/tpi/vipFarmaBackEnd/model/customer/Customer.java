package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private Long id;
    private String name;
    private String lastName;
    private IdentificationType identificationType;
    private String identification;
    private String address;
}
