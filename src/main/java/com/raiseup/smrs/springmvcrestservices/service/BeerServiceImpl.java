package com.raiseup.smrs.springmvcrestservices.service;

import com.raiseup.smrs.springmvcrestservices.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(String beerId) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Beer Name")
                .beerStyle("Beer Style")
                .upc(135L)
                .build();
    }

    @Override
    public BeerDto create(BeerDto beer) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .upc(2345L)
                .beerStyle(beer.getBeerStyle())
                .beerName(beer.getBeerName())
                .build();
    }

    @Override
    public List<BeerDto> findAll() {
        return null;
    }
}
