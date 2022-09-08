package com.raiseup.smrs.api.service;

import com.raiseup.smrs.api.repository.BeerRepository;
import com.raiseup.smrs.api.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    @Override
    public BeerDto getBeerById(Long beerId) {
        return beerRepository.findById(beerId).orElse(null);
    }

    @Override
    public BeerDto create(BeerDto beer) {
        return beerRepository.save(beer);
    }

    @Override
    public List<BeerDto> findAll() {
        return beerRepository.findAll();
    }

    @Override
    public BeerDto update(Long beerId, BeerDto beerDto) {
        BeerDto beer= new BeerDto();
        Optional<BeerDto> optionalBeerDto = beerRepository.findById(beerId);
        if(optionalBeerDto.isEmpty()){
            return beerRepository.save(beerDto);
        }else{
            beer=optionalBeerDto.get();
            beer.setBeerName(beerDto.getBeerName());
            beer.setBeerStyle(beerDto.getBeerStyle());
            beer.setLastModifiedDate(OffsetDateTime.now());
            return beerRepository.save(beer);
        }

    }
}
