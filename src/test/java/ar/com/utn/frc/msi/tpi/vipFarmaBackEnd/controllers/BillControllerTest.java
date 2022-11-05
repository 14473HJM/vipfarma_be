package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.UserLogged;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


public class BillControllerTest extends ControllersTest{

    @Test
    void getAllTest() {
        List<Bill> bills = this.restTemplate.getForObject("http://localhost:" + port + "/bills",
                List.class);
        Assertions.assertFalse(bills.isEmpty());
    }

    @Test
    void getByIdTest() {
        Bill bill = this.restTemplate.getForObject("http://localhost:" + port + "/bills/1001",
                Bill.class);
        Assertions.assertEquals(1001L, bill.getId());
    }

    @Test
    void billOrderTest() {
        UserLogged userLogged = new UserLogged(1001L);
        Bill bill = this.restTemplate.postForObject("http://localhost:" + port + "/billing/order/1001", userLogged,
                Bill.class);
        Assertions.assertEquals(BigDecimal.valueOf(363).setScale(2), bill.getTotalAmount());
    }
}
