package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping("/warehouse")
    public ResponseEntity<Warehouse> create(@RequestBody Warehouse warehouse) {
        warehouse = warehouseService.create(warehouse);
        return ResponseEntity.created(null).body(warehouse);
    }

    @GetMapping("/warehouse")
    public ResponseEntity<List<Warehouse>> getAll() {
        List<Warehouse> warehouseList = warehouseService.getAll();
        return ResponseEntity.ok(warehouseList);
    }

    @GetMapping("/warehouse/{id}")
    public ResponseEntity<Warehouse> getAll(@PathVariable Long id) {
        Warehouse warehouse = warehouseService.getById(id);
        return ResponseEntity.ok(warehouse);
    }
}
