package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.LockerEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.ProductEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.StockEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockSummary {

    private Stock stock;
    private Long value;

}
