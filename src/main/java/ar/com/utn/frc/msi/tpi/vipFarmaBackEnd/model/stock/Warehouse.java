package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Warehouse {

    private Long id;
    private String name;
    private String location;
    private BranchOffice branchOffice;
    private List<Rack> racks;
}
