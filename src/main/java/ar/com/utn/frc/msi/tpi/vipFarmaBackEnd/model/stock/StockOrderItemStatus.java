package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StockOrderItemStatus {

    CREATED(true, false),
    PENDING(false, false),
    RETURNED(false,true),
    NO_RECEIVED(false, true),
    COMPLETELY_RECEIVED(false, false),
    PARTIALLY_RECEIVED(false, false),
    STORED(false, true);

    private Boolean isInitialStatus;
    private Boolean isFinalStatus;
}
