package ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.impl;

import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.CustomerEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.entity.UserEntity;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.customer.Customer;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.model.user.User;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.repositories.CustomerRepository;
import ar.com.utn.frc.msi.tpi.vipFarmaBackEnd.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends BaseModelServiceImpl<Customer, CustomerEntity> implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    @Override
    protected JpaRepository getJpaRepository() {
        return this.customerRepository;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

}
