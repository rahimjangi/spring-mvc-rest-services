package com.raiseup.smrs.springmvcrestservices.service;

import com.raiseup.smrs.springmvcrestservices.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Beer Name")
                .beerStyle("Beer Style")
                .build();
    }
}
