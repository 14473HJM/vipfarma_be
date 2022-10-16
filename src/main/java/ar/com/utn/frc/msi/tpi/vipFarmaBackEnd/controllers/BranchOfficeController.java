package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.common.BranchOffice;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.BranchOfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BranchOfficeController {

    private final BranchOfficeService branchOfficeService;

    @PostMapping("/branchOffice")
    public ResponseEntity<BranchOffice> create(@RequestBody BranchOffice branchOffice) {
        branchOffice = branchOfficeService.create(branchOffice);
        return ResponseEntity.created(null).body(branchOffice);
    }

    @GetMapping("/branchOffice")
    public ResponseEntity<List<BranchOffice>> getAll() {
        List<BranchOffice> branchOfficeList = branchOfficeService.getAll();
        return ResponseEntity.ok(branchOfficeList);
    }

    @GetMapping("/branchOffice/{id}")
    public ResponseEntity<BranchOffice> getAll(@PathVariable Long id) {
        BranchOffice healthInsurance = branchOfficeService.getById(id);
        return ResponseEntity.ok(healthInsurance);
    }

}
