package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StockItem {

    private Long id;
    private Product product;
    private LocalDate createdDate;
    private LocalDate dueDate;
    private Integer initialStock;
    private Integer availableStock;
    private Warehouse warehouse;
    private StockItemStatus stockItemStatus;

}
