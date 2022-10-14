package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemEntity {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private BigDecimal unitaryPrice;
    private BigDecimal discountAmount;
    private BigDecimal totalPrice;
}
