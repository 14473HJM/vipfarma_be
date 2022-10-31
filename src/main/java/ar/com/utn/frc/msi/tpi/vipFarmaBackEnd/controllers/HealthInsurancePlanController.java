package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.HealthInsurancePlanService;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.HealthInsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HealthInsurancePlanController {

    private final HealthInsurancePlanService healthInsurancePlanService;

    @PostMapping("/healthInsurancePlan")
    public ResponseEntity<HealthInsurancePlan> create(@RequestBody HealthInsurancePlan healthInsurancePlan) {
        healthInsurancePlan = healthInsurancePlanService.create(healthInsurancePlan);
        return ResponseEntity.created(null).body(healthInsurancePlan);
    }

    @GetMapping("/healthInsurancePlan")
    public ResponseEntity<List<HealthInsurancePlan>> getAll() {
        List<HealthInsurancePlan> healthInsurancePlanList = healthInsurancePlanService.getAll();
        return ResponseEntity.ok(healthInsurancePlanList);
    }

    @GetMapping("/healthInsurancePlan/{id}")
    public ResponseEntity<HealthInsurancePlan> getById(@PathVariable Long id) {
        HealthInsurancePlan healthInsurancePlan = healthInsurancePlanService.getById(id);
        return ResponseEntity.ok(healthInsurancePlan);
    }

    @GetMapping("/healthInsurancePlan/insurance/{id}")
    public ResponseEntity<List<HealthInsurancePlan>> getByInsuranceId(@PathVariable Long id) {
        List<HealthInsurancePlan> healthInsurancePlans = healthInsurancePlanService.getByInsurance(id);
        return ResponseEntity.ok(healthInsurancePlans);
    }

}
