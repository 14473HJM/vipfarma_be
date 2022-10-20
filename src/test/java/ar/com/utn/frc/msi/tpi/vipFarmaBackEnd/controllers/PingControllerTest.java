package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;


class PingControllerTest extends ControllersTest{

    @Test
    void ping() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/ping",
                String.class)).contains("pong");
    }
}