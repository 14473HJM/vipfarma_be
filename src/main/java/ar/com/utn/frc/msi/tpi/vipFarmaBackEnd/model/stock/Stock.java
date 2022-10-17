package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    private Long id;
    private Product product;
    private LocalDate createdDate;
    private LocalDate endDate;
    private LocalDate dueDate;
    private Integer initialStock;
    private Integer availableStock;
    private Locker locker;
    private StockStatus stockStatus;

}
