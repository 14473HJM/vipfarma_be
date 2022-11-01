package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.BillItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "bills")
public class BillEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private CustomerEntity customer;

    @OneToOne
    @JoinColumn(name = "saleOrderId", referencedColumnName = "id")
    private SaleOrderEntity saleOrder;

    private LocalDate createdDate;
    private LocalDate dueDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "billId")
    @Fetch(FetchMode.SELECT)
    private List<BillItemEntity> items;

    private String cae;
}
