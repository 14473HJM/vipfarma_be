package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ControllersTest {

    /**
     * This Test was performed with the full server, but can be done wothout server.
     * More information here https://spring.io/guides/gs/testing-web/
     */

    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate restTemplate;
}
