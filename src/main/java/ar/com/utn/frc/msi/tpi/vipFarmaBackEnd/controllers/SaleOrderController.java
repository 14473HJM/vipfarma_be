package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.common.ErrorDTO;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class SaleOrderController {

    private final SaleOrderService saleOrderService;

    @PostMapping("/sale/orders")
    public ResponseEntity<SaleOrder> create(@RequestBody SaleOrder saleOrder) {
        saleOrder = saleOrderService.create(saleOrder);
        return ResponseEntity.created(null).body(saleOrder);
    }

    @GetMapping("/sale/orders")
    public ResponseEntity<List<SaleOrder>> getOrders(@RequestParam(required = false) SaleOrderStatus saleOrderStatus,
                                                     @RequestParam(required = false) Long branchOfficeId) {
        List<SaleOrder> saleOrderList = new LinkedList<>();
        if(saleOrderStatus == null && branchOfficeId == null) {
            saleOrderList = saleOrderService.getAll();
        } else if (saleOrderStatus != null && branchOfficeId != null) {
            saleOrderList = saleOrderService.getOrdersByStatusAndBranchOffice(saleOrderStatus, branchOfficeId);
        } else {
            throw new IllegalArgumentException("Both parameters are required, saleOrderStatus and branchOfficeId");
        }
        return ResponseEntity.ok(saleOrderList);
    }

    @GetMapping("/sale/orders/{id}")
    public ResponseEntity<SaleOrder> getOrder(@PathVariable("id") Long id) {
        SaleOrder saleOrder = saleOrderService.getById(id);
        return ResponseEntity.ok(saleOrder);
    }

    @PutMapping("/sale/orders/{id}/status/{status}")
    public ResponseEntity<SaleOrder> changeStatus(@PathVariable("id") Long id,
                                            @PathVariable("status") SaleOrderStatus saleOrderStatus) {
        SaleOrder saleOrder = saleOrderService.changeStatus(id, saleOrderStatus);
        return ResponseEntity.ok(saleOrder);
    }

    @PutMapping("/sale/orders/{id}")
    public ResponseEntity<SaleOrder> changeOrder(@PathVariable("orderId") Long id,
                                                  @RequestBody SaleOrder saleOrder) {
        saleOrder = saleOrderService.update(saleOrder);
        return ResponseEntity.ok(saleOrder);
    }
}
