package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "billItems")
public class BillItemEntity extends Deleteable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JoinColumn(name="billId")
    private Long billId;

    private String labelInvoice;

    @OneToOne
    @JoinColumn(name = "offerId", referencedColumnName = "id")
    private OfferEntity offer;

    private Integer quantity;
    private BigDecimal unitaryPrice;
    private BigDecimal discountAmount;
    private BigDecimal totalPrice;
}
