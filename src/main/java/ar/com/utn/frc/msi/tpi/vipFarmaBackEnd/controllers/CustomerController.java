package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.controllers;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.catalog.HealthInsurance;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> login(@RequestBody Customer customer ) {
        customer = customerService.create(customer);
        return ResponseEntity.created(null).body(customer);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customerList = customerService.getAll();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        if(customer != null) {
            customerService.delete(customer);
        } else {
            throw new EntityNotFoundException(String.format("Customer id %s not found", id));
        }
        return ResponseEntity.ok().body(null);
    }
}
