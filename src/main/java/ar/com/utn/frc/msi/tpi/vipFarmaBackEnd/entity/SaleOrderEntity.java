package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.OrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "saleOrder")
public class SaleOrderEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long userId;
    private Long customerId;
    private Long branchOfficeId;
    private LocalDate createdDate;
    private String saleOrderStatus;
    private String statusDetail;
    private BigDecimal totalAmount;
}
