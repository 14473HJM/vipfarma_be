package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StockOrderStatus {

    CREATED(true, false),
    PENDING_DELIVERY(false, false),
    RECEIVED(false, true),
    REJECTED(false, true),
    CANCELED(false, true);

    private Boolean isInitialStatus;
    private Boolean isFinalStatus;

}
