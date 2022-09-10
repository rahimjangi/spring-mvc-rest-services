package com.raiseup.smrs.api.mappers;

import com.raiseup.smrs.api.entity.Beer;
import com.raiseup.smrs.api.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beer(BeerDto beerDto);
    BeerDto beerDto(Beer beer);
}
