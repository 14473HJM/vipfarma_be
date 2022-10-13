package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class StockOrder {

    private Long id;
    private Long purchaseOrderId;
    private Warehouse warehouse;
    private LocalDate createdDate;
    private LocalDate endDate;
    private StockOrderStatus stockOrderStatus;
    private String statusReason;
    private String statusComment;
    private List<StockOrderItem> stockOrderItems;

}
