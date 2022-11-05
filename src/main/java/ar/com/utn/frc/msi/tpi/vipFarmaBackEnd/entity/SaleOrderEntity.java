package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "saleOrders")
public class SaleOrderEntity extends Deleteable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity userId;

    @OneToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private CustomerEntity customerId;

    @OneToOne
    @JoinColumn(name = "branchOfficeId", referencedColumnName = "id")
    private BranchOfficeEntity branchOfficeId;

    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private SaleOrderStatus saleOrderStatus;
    private String statusDetail;
    private BigDecimal totalAmount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "saleOrderId")
    private List<SaleOrderItemEntity> saleOrderItems;
}
