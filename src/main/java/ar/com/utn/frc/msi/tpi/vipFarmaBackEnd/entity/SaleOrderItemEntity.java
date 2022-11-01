package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity(name = "saleOrderItems")
public class SaleOrderItemEntity extends Deleteable {

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orderItemStocks",
            joinColumns = @JoinColumn(name = "saleOrderItemId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "stockId", referencedColumnName = "id"))
    private List<StockEntity> stocks;
}
