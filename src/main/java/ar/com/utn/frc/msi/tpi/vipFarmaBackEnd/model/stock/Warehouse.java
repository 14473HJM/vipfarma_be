package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Warehouse {

    private Long id;
    private String name;
    private String location;

}
