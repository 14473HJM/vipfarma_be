package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    /**
     * Prueba TPI-01
     * @return
     */
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
