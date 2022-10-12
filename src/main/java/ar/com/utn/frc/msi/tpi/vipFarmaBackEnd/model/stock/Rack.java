package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Rack {

    private Long id;
    private String name;
    private Long warehouseId;
    private List<Locker> lockers;
}
