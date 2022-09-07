package com.raiseup.smrs.springmvcrestservices.service;

import com.raiseup.smrs.springmvcrestservices.web.model.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    CustomerDto findById(String id);

    CustomerDto create(CustomerDto customer);
}
