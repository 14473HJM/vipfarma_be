package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Rack;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.RackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RackController {

    private final RackService rackService;

    @PostMapping("/racks")
    public ResponseEntity<Rack> create(@RequestBody Rack rack) {
        rack = rackService.create(rack);
        return ResponseEntity.created(null).body(rack);
    }

    @GetMapping("/racks")
    public ResponseEntity<List<Rack>> getAll() {
        List<Rack> rackList = rackService.getAll();
        return ResponseEntity.ok(rackList);
    }

    @GetMapping("/racks/{id}")
    public ResponseEntity<Rack> getAll(@PathVariable Long id) {
        Rack rack = rackService.getById(id);
        return ResponseEntity.ok(rack);
    }
}
