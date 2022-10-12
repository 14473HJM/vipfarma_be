package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StockTransaction {

    private Long id;
    private Long stockOrderId;
    private StockTransactionType stockTransactionType;
    private StockOrderItem stockOrderItem;
    private Stock stock;
    private Product product;
    private Integer quantity;
    private LocalDate effectiveDate;

}
