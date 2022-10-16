package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.CustomerEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.UserEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.CustomerRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerService customerService;
    private final ModelMapper modelMapper;


    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity costumerEntity = modelMapper.map(customer, CustomerEntity.class);
        costumerEntity = CustomerRepository.save(costumerEntity);
        return modelMapper.map(costumerEntity, Customer.class);
    }
}
