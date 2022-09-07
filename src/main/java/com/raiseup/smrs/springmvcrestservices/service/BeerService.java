package com.raiseup.smrs.springmvcrestservices.service;

import com.raiseup.smrs.springmvcrestservices.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeerService {
    BeerDto getBeerById(String beerId);

    BeerDto create(BeerDto beer);

    List<BeerDto> findAll();
}
