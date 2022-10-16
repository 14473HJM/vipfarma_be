package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/customer/create")
    public ResponseEntity<Customer> login(@RequestBody Customer customer ) {
        customer = customerService.createCustomer(customer);

        return ResponseEntity.created(null).body(customer);
    }
    

}
