package com.raiseup.smrs.api.service;

import com.raiseup.smrs.api.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BeerService {
    BeerDto getBeerById(Long beerId);

    BeerDto create(BeerDto beer);

    List<BeerDto> findAll();

    BeerDto update(Long beerId, BeerDto beerDto);

    void deleteBeerById(Long beerId);
}
