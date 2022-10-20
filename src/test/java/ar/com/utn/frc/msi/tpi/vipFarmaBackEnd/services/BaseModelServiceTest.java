package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.BillItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Tax;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Offer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.Product;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderItem;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Rack;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class BaseModelServiceTest {

    @Autowired private BillService billService;
    @Autowired private BillItemService billItemService;
    @Autowired private BranchOfficeService branchOfficeService;
    @Autowired private CustomerService customerService;
    @Autowired private HealthInsuranceService healthInsuranceService;
    @Autowired private HealthInsurancePlanService healthInsurancePlanService;
    @Autowired private LockerService lockerService;
    @Autowired private OfferService offerService;
    @Autowired private ProductService productService;
    @Autowired private RackService rackService;
    @Autowired private SaleOrderService saleOrderService;
    @Autowired private SaleOrderItemService saleOrderItemService;
    @Autowired private StockService stockService;
    @Autowired private TaxService taxService;
    @Autowired private UserService userService;
    @Autowired private WarehouseService warehouseService;

    @Test
    public void getByIdTest() {
        Long id = 1001L;
        Bill bill = billService.getById(id);
        Assertions.assertNotNull(bill);

        BillItem billItem = billItemService.getById(id);
        Assertions.assertNotNull(billItem);

        BranchOffice branchOffice = branchOfficeService.getById(id);
        Assertions.assertNotNull(branchOffice);

        Customer customer = customerService.getById(id);
        Assertions.assertNotNull(customer);

        HealthInsurance healthInsurance = healthInsuranceService.getById(id);
        Assertions.assertNotNull(healthInsurance);

        HealthInsurancePlan healthInsurancePlan = healthInsurancePlanService.getById(id);
        Assertions.assertNotNull(healthInsurancePlan);

        Locker locker = lockerService.getById(id);
        Assertions.assertNotNull(locker);

        Offer offer = offerService.getById(id);
        Assertions.assertNotNull(offer);

        Product product = productService.getById(id);
        Assertions.assertNotNull(product);

        Rack rack = rackService.getById(id);
        Assertions.assertNotNull(rack);

        SaleOrder saleOrder = saleOrderService.getById(id);
        Assertions.assertNotNull(saleOrder);

        SaleOrderItem saleOrderItem = saleOrderItemService.getById(id);
        Assertions.assertNotNull(saleOrderItem);

        Stock stock = stockService.getById(id);
        Assertions.assertNotNull(stock);

        Tax tax = taxService.getById(id);
        Assertions.assertNotNull(tax);

        User user = userService.getById(id);
        Assertions.assertNotNull(user);

        Warehouse warehouse = warehouseService.getById(id);
        Assertions.assertNotNull(warehouse);
    }

    @Test
    public void createTest() {
        Long id = 1001L;
        Bill bill = billService.getById(id);
        bill.setId(null);
        bill = billService.create(bill);
        Assertions.assertNotNull(bill.getId());

        BillItem billItem = billItemService.getById(id);
        billItem.setId(null);
        billItem = billItemService.create(billItem);
        Assertions.assertNotNull(billItem.getId());

        BranchOffice branchOffice = branchOfficeService.getById(id);
        branchOffice.setId(null);
        branchOffice = branchOfficeService.create(branchOffice);
        Assertions.assertNotNull(branchOffice.getId());

        Customer customer = customerService.getById(id);
        customer.setId(null);
        customer = customerService.create(customer);
        Assertions.assertNotNull(customer.getId());

        HealthInsurance healthInsurance = healthInsuranceService.getById(id);
        healthInsurance.setId(null);
        healthInsurance = healthInsuranceService.create(healthInsurance);
        Assertions.assertNotNull(healthInsurance.getId());

        HealthInsurancePlan healthInsurancePlan = healthInsurancePlanService.getById(id);
        healthInsurancePlan.setId(null);
        healthInsurancePlan = healthInsurancePlanService.create(healthInsurancePlan);
        Assertions.assertNotNull(healthInsurancePlan.getId());

        Locker locker = lockerService.getById(id);
        locker.setId(null);
        locker = lockerService.create(locker);
        Assertions.assertNotNull(locker.getId());

        Offer offer = offerService.getById(id);
        offer.setId(null);
        offer = offerService.create(offer);
        Assertions.assertNotNull(offer.getId());

        Product product = productService.getById(id);
        product.setId(null);
        product = productService.create(product);
        Assertions.assertNotNull(product.getId());

        Rack rack = rackService.getById(id);
        rack.setId(null);
        rack = rackService.create(rack);
        Assertions.assertNotNull(rack.getId());

        SaleOrder saleOrder = saleOrderService.getById(id);
        saleOrder.setId(null);
        saleOrder = saleOrderService.create(saleOrder);
        Assertions.assertNotNull(saleOrder.getId());

        SaleOrderItem saleOrderItem = saleOrderItemService.getById(id);
        saleOrderItem.setId(null);
        saleOrderItem = saleOrderItemService.create(saleOrderItem);
        Assertions.assertNotNull(saleOrderItem.getId());

        Stock stock = stockService.getById(id);
        stock.setId(null);
        stock = stockService.create(stock);
        Assertions.assertNotNull(stock.getId());

        Tax tax = taxService.getById(id);
        tax.setId(null);
        tax = taxService.create(tax);
        Assertions.assertNotNull(tax.getId());

        User user = userService.getById(id);
        user.setId(null);
        user = userService.create(user);
        Assertions.assertNotNull(user.getId());

        Warehouse warehouse = warehouseService.getById(id);
        warehouse.setId(null);
        warehouse = warehouseService.create(warehouse);
        Assertions.assertNotNull(warehouse.getId());
    }

    @Test
    public void getAllTest() {
        List<Bill> bill = billService.getAll();
        Assertions.assertNotNull(bill);
        Assertions.assertFalse(bill.isEmpty());

        List<BillItem> billItem = billItemService.getAll();
        Assertions.assertNotNull(billItem);
        Assertions.assertFalse(billItem.isEmpty());

        List<BranchOffice> branchOffice = branchOfficeService.getAll();
        Assertions.assertNotNull(branchOffice);
        Assertions.assertFalse(branchOffice.isEmpty());

        List<Customer> customer = customerService.getAll();
        Assertions.assertNotNull(customer);
        Assertions.assertFalse(customer.isEmpty());

        List<HealthInsurance> healthInsurance = healthInsuranceService.getAll();
        Assertions.assertNotNull(healthInsurance);
        Assertions.assertFalse(healthInsurance.isEmpty());

        List<HealthInsurancePlan> healthInsurancePlan = healthInsurancePlanService.getAll();
        Assertions.assertNotNull(healthInsurancePlan);
        Assertions.assertFalse(healthInsurancePlan.isEmpty());

        List<Locker> locker = lockerService.getAll();
        Assertions.assertNotNull(locker);
        Assertions.assertFalse(locker.isEmpty());

        List<Offer> offer = offerService.getAll();
        Assertions.assertNotNull(offer);
        Assertions.assertFalse(offer.isEmpty());

        List<Product> product = productService.getAll();
        Assertions.assertNotNull(product);
        Assertions.assertFalse(product.isEmpty());

        List<Rack> rack = rackService.getAll();
        Assertions.assertNotNull(rack);
        Assertions.assertFalse(rack.isEmpty());

        List<SaleOrder> saleOrder = saleOrderService.getAll();
        Assertions.assertNotNull(saleOrder);
        Assertions.assertFalse(saleOrder.isEmpty());

        List<SaleOrderItem> saleOrderItem = saleOrderItemService.getAll();
        Assertions.assertNotNull(saleOrderItem);
        Assertions.assertFalse(saleOrderItem.isEmpty());

        List<Stock> stock = stockService.getAll();
        Assertions.assertNotNull(stock);
        Assertions.assertFalse(stock.isEmpty());

        List<Tax> tax = taxService.getAll();
        Assertions.assertNotNull(tax);
        Assertions.assertFalse(tax.isEmpty());

        List<User> user = userService.getAll();
        Assertions.assertNotNull(user);
        Assertions.assertFalse(user.isEmpty());

        List<Warehouse> warehouse = warehouseService.getAll();
        Assertions.assertNotNull(warehouse);
        Assertions.assertFalse(bill.isEmpty());
    }
}
