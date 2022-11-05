package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Locker;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.stock.Warehouse;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.LockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class LockerController {

    private final LockerService lockerService;

    @PostMapping("/lockers")
    public ResponseEntity<Locker> create(@RequestBody Locker locker) {
        locker = lockerService.create(locker);
        return ResponseEntity.created(null).body(locker);
    }

    @GetMapping("/lockers")
    public ResponseEntity<List<Locker>> getAll(@RequestParam(required = false) Long productId,
                                               @RequestParam(required = false) Integer availability) {
        List<Locker> lockerList;
        if(productId == null && availability == null) {
            lockerList = lockerService.getAll();
        } else if (productId != null && availability == null) {
            lockerList = lockerService.getAllByProduct(productId);
        } else if (productId != null && availability != null) {
            lockerList = lockerService.getAllByProductAndAvailability(productId, availability);
        } else {
            throw new IllegalArgumentException("productId is required if availability included");
        }
        return ResponseEntity.ok(lockerList);
    }

    @GetMapping("/lockers/{id}")
    public ResponseEntity<Locker> getById(@PathVariable Long id) {
        Locker locker = lockerService.getById(id);
        return ResponseEntity.ok(locker);
    }
}
