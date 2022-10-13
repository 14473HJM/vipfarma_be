package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class BillItem {

    private Long id;
    private Long billId;
    private Product product;
    private Integer quantity;
    private BigDecimal unitaryPrice;
    private BigDecimal discountAmount;
    private BigDecimal totalPrice;
}
