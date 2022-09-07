package com.raiseup.smrs.springmvcrestservices.service;

import com.raiseup.smrs.springmvcrestservices.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto findById(String id) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .firstName("Rahim")
                .lastName("Jangi")
                .build();
    }

    @Override
    public CustomerDto create(CustomerDto customer) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
