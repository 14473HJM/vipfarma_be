package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "saleOrderItems")
public class SaleOrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name="saleOrderId")
    private Long saleOrderId;

    @OneToOne
    @JoinColumn(name = "offerId", referencedColumnName = "id")
    private OfferEntity offerId;
    private Integer quantity;
    private BigDecimal unitaryPrice;
    private BigDecimal discountAmount;
    private BigDecimal totalPrice;

    @ManyToMany
    @JoinTable(
            name = "orderItemStocks",
            joinColumns = @JoinColumn(name = "saleOrderItemId"),
            inverseJoinColumns = @JoinColumn(name = "stockId"))
    private List<StockEntity> stocks;
}
