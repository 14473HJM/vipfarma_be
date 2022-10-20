package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.HealthInsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HealthInsuranceController {

    private final HealthInsuranceService healthInsuranceService;

    @PostMapping("/healthInsurance")
    public ResponseEntity<HealthInsurance> create(@RequestBody HealthInsurance healthInsurance) {
        healthInsurance = healthInsuranceService.create(healthInsurance);
        return ResponseEntity.created(null).body(healthInsurance);
    }

    @GetMapping("/healthInsurance")
    public ResponseEntity<List<HealthInsurance>> getAll() {
        List<HealthInsurance> healthInsuranceList = healthInsuranceService.getAll();
        return ResponseEntity.ok(healthInsuranceList);
    }

    @GetMapping("/healthInsurance/{id}")
    public ResponseEntity<HealthInsurance> getById(@PathVariable Long id) {
        HealthInsurance healthInsurance = healthInsuranceService.getById(id);
        return ResponseEntity.ok(healthInsurance);
    }
}
