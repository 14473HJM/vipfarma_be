package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleOrder {

    private Long id;
    private User user;
    private Customer customer;
    private LocalDate createdDate;
    private SaleOrderStatus saleOrderStatus;
    private String statusDetail;
    private List<OrderItem> orderItems;
    private BigDecimal totalAmount;
}
