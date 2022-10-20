package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.BillItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Tax;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.TaxType;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Offer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.BillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillItemServiceTest {

    @SpyBean
    private BillService billService;

    @MockBean private BillRepository billRepository;

    @MockBean private TaxService taxService;

    @MockBean private SaleOrderService saleOrderService;

    @MockBean private BillItemService billItemService;

    @MockBean private ModelMapper modelMapper;

    @Test
    public void getCaeTest() {
        // given
        String caeExpected = "1234567891234567890";
        // when
        String caeResult = ReflectionTestUtils.invokeMethod(billService, "getCae");
        // then
        Assertions.assertEquals(caeExpected, caeResult);
    }

    @Test
    public void getDueDateTest() {
        // given
        LocalDate expectedDate = LocalDate.now().plusDays(1L);
        // when
        LocalDate resultDate = ReflectionTestUtils.invokeMethod(billService, "getDueDate");
        // then
        Assertions.assertEquals(expectedDate, resultDate);
    }

    @Test
    public void calculateTaxTest() {
        // given
        BigDecimal expectedAmount = BigDecimal.valueOf(210.00).setScale(2, RoundingMode.HALF_UP);
        Tax tax = new Tax(1L, TaxType.VAT, "Iva Consumidor Final", BigDecimal.valueOf(0.21));
        BillItem item = new BillItem(1L, 1L, new Offer(), 1, "Offer 1",
                BigDecimal.valueOf(1000), BigDecimal.ZERO, BigDecimal.valueOf(1000));
        // when
        BigDecimal resultAmount = ReflectionTestUtils.invokeMethod(billService, "calculateTax", item, tax);
        // then
        Assertions.assertEquals(expectedAmount, resultAmount);
    }

    @Test
    public void calculateTaxesTest() {
        // given
        Long billId = 1001L;
        BigDecimal expectedAmount = BigDecimal.valueOf(210.00).setScale(2);
        String expectedLabel = "Iva Consumidor Final";
        List<BillItem> items = new LinkedList<>();
        Tax tax = new Tax(1L, TaxType.VAT, "Iva Consumidor Final", BigDecimal.valueOf(0.21));
        BillItem item = new BillItem(1L, 1L, new Offer(), 1, "Offer 1",
                BigDecimal.valueOf(1000), BigDecimal.ZERO, BigDecimal.valueOf(1000));
        items.add(item);
        given(taxService.getTaxByTaxType(TaxType.VAT)).willReturn(tax);
        // when
        ReflectionTestUtils.invokeMethod(billService, "calculateTaxes", items, billId);
        // then
        Assertions.assertEquals(2, items.size());
        Assertions.assertEquals(expectedAmount, items.get(1).getTotalPrice());
        Assertions.assertEquals(expectedLabel, items.get(1).getLabelInvoice());
    }

    @Test
    public void billOrderTest() {
        // given
        BigDecimal price = BigDecimal.valueOf(1000).setScale(2);
        HealthInsurancePlan healthInsurancePlan = new HealthInsurancePlan(1L, "OSDE 410", null, 1L);
        HealthInsurance healthInsurance = new HealthInsurance(1L, "OSDE", null, Arrays.asList(healthInsurancePlan));
        Product product = new Product(1L, "Producto 1", 123456789L, "Laboratorio A",
                false, BigDecimal.valueOf(1000).setScale(2));
        Offer offer = new Offer(1L, product, healthInsurance, healthInsurancePlan, null, null, price);
        SaleOrderItem saleOrderItem = new SaleOrderItem(1L, 1L, offer, 1, price, null, null);
        SaleOrder saleOrder = new SaleOrder(1L, new User(), new Customer(), LocalDate.now(),
                SaleOrderStatus.READY_TO_BILL, null, Arrays.asList(saleOrderItem), null);
        BillItem billItem = new BillItem(1L, 1L, new Offer(), 1, "Offer 1",
                BigDecimal.valueOf(1000), BigDecimal.ZERO, BigDecimal.valueOf(1000));
        Bill bill = new Bill(1L, null, new Customer(), 1L,  LocalDate.now(), null, null, null);
        Tax tax = new Tax(1L, TaxType.VAT, "Iva Consumidor Final", BigDecimal.valueOf(0.21));
        given(saleOrderService.getById(1L)).willReturn(saleOrder);
        given(billService.create(Mockito.any())).willReturn(bill);
        given(billItemService.billingItem(saleOrderItem, 1L)).willReturn(billItem);
        given(billItemService.createAll(Mockito.anyList())).willReturn(Arrays.asList(billItem));
        given(taxService.getTaxByTaxType(TaxType.VAT)).willReturn(tax);
        // when
        bill = billService.billOrder(1L, 1L);
        // then
        Assertions.assertNotNull(bill.getItems());
    }
}
