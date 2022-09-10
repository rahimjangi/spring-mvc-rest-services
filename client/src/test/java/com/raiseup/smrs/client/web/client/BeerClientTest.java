package com.raiseup.smrs.client.web.client;

import com.raiseup.smrs.client.model.BearStyleEnum;
import com.raiseup.smrs.client.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@SpringBootTest
@Slf4j
class BeerClientTest {
    @Autowired
    BeerClient beerClient;

    @Test
    void getById(){
        BeerDto rahimBeer = BeerDto.builder()
                .beerName("rahim")
                .version(1)
                .createDate(OffsetDateTime.now())
                .beerStyle(BearStyleEnum.LAGER)
                .upc(23469867L)
                .price(BigDecimal.valueOf(34.43)).build();
        BeerDto beerDto = beerClient.saveBeer(rahimBeer);
        BeerDto beer = beerClient.getBeerById(beerDto.getId());
        assertNotNull(beer);
    }

    @Test
    void saveBeerDto(){
        BeerDto rahimBeer = BeerDto.builder()
                .beerName("rahim1")
                .version(1)
                .beerStyle(BearStyleEnum.LAGER)
                .createDate(OffsetDateTime.now())
                .upc(2346943867L)
                .price(BigDecimal.valueOf(34.43)).build();
        BeerDto beerDto = beerClient.saveBeer(rahimBeer);

        assertNotNull(rahimBeer);
        assertEquals(beerDto.getBeerName(),rahimBeer.getBeerName());
    }

    @Test
    void updateBeerDto(){
        BeerDto rahimBeer = BeerDto.builder()
                .beerName("rahim2")
                .version(1)
                .beerStyle(BearStyleEnum.LAGER)
                .createDate(OffsetDateTime.now())
                .upc(234569867L)
                .price(BigDecimal.valueOf(34.43)).build();
        BeerDto beerDto = beerClient.saveBeer(rahimBeer);
        beerDto.setUpc(324L);
        beerDto.setVersion(32);
        beerClient.updateBeer(beerDto.getId(),beerDto);
        BeerDto beerById = beerClient.getBeerById(beerDto.getId());
        assertEquals(beerById.getPrice(),beerDto.getPrice());
    }

    @Test
    void canDeleteBeerDto(){
        BeerDto rahimBeer = BeerDto.builder()
                .beerName("rahim3")
                .version(1)
                .beerStyle(BearStyleEnum.LAGER)
                .createDate(OffsetDateTime.now())
                .upc(234692867L)
                .price(BigDecimal.valueOf(34.43)).build();
        BeerDto beerDto = beerClient.saveBeer(rahimBeer);
        log.info("Beer ID: {}",beerDto.getId());
        beerClient.deleteBeer(beerDto.getId());
//        assertNull(beerClient.getBeerById(beerDto.getId()));
    }

}