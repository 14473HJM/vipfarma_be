package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services;


import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsuranceEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.HealthInsurancePlanEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurancePlan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HealthInsuranceServiceTest {

    @Autowired
    private HealthInsuranceService healthInsuranceService;

    @Autowired
    private HealthInsurancePlanService healthInsurancePlanService;

    @Test
    void createHealthInsuranceTest() {
        HealthInsurancePlan hip = new HealthInsurancePlan();
        hip.setName("OSDE 210");
        HealthInsurance hi = new HealthInsurance();
        hi.setName("OSDE");
        hi.setAvailablePlans(Arrays.asList(hip));
        HealthInsurance result = healthInsuranceService.createHealthInsurance(hi);
    }
}
