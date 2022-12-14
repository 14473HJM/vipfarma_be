package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillItem {

    private Long id;
    private Long billId;
    private Offer offer;
    private Integer quantity;
    private String labelInvoice;
    private BigDecimal unitaryPrice;
    private BigDecimal discountAmount;
    private BigDecimal totalPrice;
}
