package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.UserLogged;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@DisplayName("Tests - Billing Apis")
public class BillControllerTest extends ControllersTest{

    @Test
    @DisplayName("Tests - Obtener todas las Facturas")
    void getAllTest() {
        List<Bill> bills = this.restTemplate.getForObject("http://localhost:" + port + "/bills",
                List.class);
        Assertions.assertFalse(bills.isEmpty());
    }

    @Test
    @DisplayName("Tests - Obtener una factura por su identificador")
    void getByIdTest() {
        Bill bill = this.restTemplate.getForObject("http://localhost:" + port + "/bills/1001",
                Bill.class);
        Assertions.assertEquals(1001L, bill.getId());
    }

    @Test
    @DisplayName("Tests - Facturar una orden")
    void billOrderTest() {
        UserLogged userLogged = new UserLogged(1001L);
        Bill bill = this.restTemplate.postForObject("http://localhost:" + port + "/billing/order/1001?preview=false", userLogged,
                Bill.class);
        Assertions.assertEquals(BigDecimal.valueOf(1060.00).setScale(2), bill.getTotalAmount());
    }

    @Test
    @DisplayName("Tests - Crear una factura")
    void create() {
    }

}
