package com.raiseup.smrs.springmvcrestservices.web.controller;

import com.raiseup.smrs.springmvcrestservices.service.CustomerService;
import com.raiseup.smrs.springmvcrestservices.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto>getCustomerById(@PathVariable("customerId") String id){
        log.info("What a good tools to have!");
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto>createBeer(@RequestBody CustomerDto customer){
        return new ResponseEntity<>(customerService.create(customer),HttpStatus.ACCEPTED);
    }
}
