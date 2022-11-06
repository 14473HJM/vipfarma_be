package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Stock;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockStatus;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.StockSummary;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/stock/summary")
    public ResponseEntity<List<StockSummary>> getStocks(@RequestParam(required = false) Long productId,
                                                       @RequestParam(required = false) StockStatus stockStatus,
                                                       @RequestParam(required = false) Long lockerId) {
        List<StockSummary> stockSummaries = stockService.getStockSummary(productId, stockStatus, lockerId);
        return ResponseEntity.ok(stockSummaries);
    }

    @GetMapping("/stock/summary/group")
    public ResponseEntity<List<StockSummary>> getStocksGrouped() {
        List<StockSummary> stockSummaries = stockService.getStockSummaryGrouped();
        return ResponseEntity.ok(stockSummaries);
    }
}
