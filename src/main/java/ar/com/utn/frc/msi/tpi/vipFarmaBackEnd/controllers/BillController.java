package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.billing.Bill;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.UserLogged;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping("/bills")
    public ResponseEntity<Bill> create(@RequestBody Bill bill) {
        bill = billService.create(bill);
        return ResponseEntity.created(null).body(bill);
    }

    @PostMapping("/billing/order/{id}")
    public ResponseEntity<Bill> billOrder(@PathVariable Long id,
                                          @Valid @RequestBody UserLogged userLogged) {
        Bill bill = billService.billOrder(id, userLogged.getId());
        return ResponseEntity.created(null).body(bill);
    }

    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> getAll() {
        List<Bill> billList = billService.getAll();
        return ResponseEntity.ok(billList);
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<Bill> getById(@PathVariable Long id) {
        Bill bill = billService.getById(id);
        return ResponseEntity.ok(bill);
    }
}
