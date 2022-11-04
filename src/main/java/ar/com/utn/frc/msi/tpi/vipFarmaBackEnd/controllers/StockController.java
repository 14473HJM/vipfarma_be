package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.sale.SaleOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrder;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockOrderStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockOrderService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockOrderService stockOrderService;


    @PostMapping("/stock/orders")
    public ResponseEntity<StockOrder> create(@RequestBody StockOrder stockOrder) {
        stockOrder = stockOrderService.create(stockOrder);
        return ResponseEntity.created(null).body(stockOrder);
    }

    @GetMapping("/stock/orders")
    public ResponseEntity<List<StockOrder>> getOrders(@RequestParam(required = false) StockOrderStatus stockOrderStatus,
                                                     @RequestParam(required = false) Long warehouseId,
                                                      @RequestParam(required = false) Long branchOfficeId) {
        List<StockOrder> stockOrderList;
        if(stockOrderStatus == null && warehouseId == null) {
            stockOrderList = stockOrderService.getAll();
        } else if (stockOrderStatus != null && warehouseId != null && branchOfficeId == null) {
            stockOrderList = stockOrderService.getOrdersByStatusAndWarehouse(stockOrderStatus, warehouseId);
        } else if (stockOrderStatus != null && branchOfficeId != null && warehouseId == null) {
            stockOrderList = stockOrderService.getOrdersByStatusAndBranchOffice(stockOrderStatus, branchOfficeId);
        } else {
            throw new IllegalArgumentException("Both parameters are required, saleOrderStatus and branchOfficeId");
        }
        return ResponseEntity.ok(stockOrderList);
    }

    @GetMapping("/stock/orders/{id}")
    public ResponseEntity<StockOrder> getOrder(@PathVariable("id") Long id) {
        StockOrder stockOrder = stockOrderService.getById(id);
        return ResponseEntity.ok(stockOrder);
    }

    @PutMapping("/stock/orders/{id}/status/{status}")
    public ResponseEntity<StockOrder> changeStatus(@PathVariable("id") Long id,
                                                  @PathVariable("status") StockOrderStatus stockOrderStatus,
                                                   @RequestBody(required = false) StockOrder stockOrder) {
        StockOrder stockOrderChanged = stockOrderService.changeStatus(id, stockOrderStatus, stockOrder);
        return ResponseEntity.ok(stockOrderChanged);
    }

    @PutMapping("/stock/orders/{id}")
    public ResponseEntity<StockOrder> changeOrder(@PathVariable("orderId") Long id,
                                                 @RequestBody StockOrder stockOrder) {
        stockOrder = stockOrderService.update(stockOrder);
        return ResponseEntity.ok(stockOrder);
    }

}
