package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rack {

    private Long id;
    private String name;
    private Warehouse warehouse;
    private List<Locker> lockers;
}
