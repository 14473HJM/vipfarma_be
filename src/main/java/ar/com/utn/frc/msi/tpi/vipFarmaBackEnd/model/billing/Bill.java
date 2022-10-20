package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing;

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
public class Bill {

    private Long id;
    private User user;
    private Customer customer;
    private Long orderId;
    private LocalDate createdDate;
    private LocalDate dueDate;
    private List<BillItem> items;
    private String cae;
    private BigDecimal totalAmount;
}
