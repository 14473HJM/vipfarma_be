package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.SaleOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SaleOrderController {

    private SaleOrderService saleOrderService;

    @PostMapping("/sale/order")
    public ResponseEntity<SaleOrder> create(@RequestBody SaleOrder saleOrder) {
        saleOrder = saleOrderService.createOrder(saleOrder);
        return ResponseEntity.created(null).body(saleOrder);
    }

    @GetMapping("/sale/order")
    public ResponseEntity<List<SaleOrder>> getOrders(@RequestParam String saleOrderStatus,
                                                     @RequestParam String branchOffice) {
        List<SaleOrder> saleOrderList = saleOrderService.getOrders(saleOrderStatus, branchOffice);
        return ResponseEntity.ok(saleOrderList);
    }

    @GetMapping("/sale/order/{orderId}")
    public ResponseEntity<SaleOrder> getOrder(@PathVariable("orderId") Long id) {
        SaleOrder saleOrder = saleOrderService.getOrder(id);
        return ResponseEntity.ok(saleOrder);
    }

    @PutMapping("/sale/order/{orderId}/status/{status}")
    public ResponseEntity<SaleOrder> changeStatus(@PathVariable("orderId") Long id,
                                            @PathVariable("status") String status) {
        SaleOrder saleOrder = saleOrderService.changeStatus(id, status);
        return ResponseEntity.ok(saleOrder);
    }

    @PutMapping("/sale/order/{orderId}")
    public ResponseEntity<SaleOrder> changeOrder(@PathVariable("orderId") Long id,
                                                  @RequestBody SaleOrder saleOrder) {
        saleOrder = saleOrderService.changeOrder(id, saleOrder);
        return ResponseEntity.ok(saleOrder);
    }
}
