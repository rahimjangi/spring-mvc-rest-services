package com.raiseup.smrs.client.web.client;

import com.raiseup.smrs.client.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BeerClientTest {
    @Autowired
    BeerClient beerClient;

    @Test
    void getById(){
        BeerDto beer = beerClient.getBeerById(1L);
        assertNotNull(beer);
    }

    @Test
    void saveBeerDto(){
        BeerDto rahimBeer = BeerDto.builder().beerName("rahim").price(BigDecimal.valueOf(34.43)).build();
        BeerDto beerDto = beerClient.saveBeer(rahimBeer);

        assertNotNull(rahimBeer);
        assertEquals(beerDto.getBeerName(),rahimBeer.getBeerName());
    }

    @Test
    void updateBeerDto(){
        BeerDto rahimBeer = BeerDto.builder().beerName("rahim").price(BigDecimal.valueOf(34.43)).build();
        BeerDto beerDto = beerClient.saveBeer(rahimBeer);
        beerDto.setUpc(324L);
        beerDto.setVersion(32);
        beerClient.updateBeer(beerDto.getId(),beerDto);
        BeerDto beerById = beerClient.getBeerById(beerDto.getId());
        assertEquals(beerById.getPrice(),beerDto.getPrice());
    }

    @Test
    void canDeleteBeerDto(){
        BeerDto rahimBeer = BeerDto.builder().beerName("rahim").price(BigDecimal.valueOf(34.43)).build();
        BeerDto beerDto = beerClient.saveBeer(rahimBeer);
        log.info("Beer ID: {}",beerDto.getId());
        beerClient.deleteBeer(beerDto.getId());
//        assertNull(beerClient.getBeerById(beerDto.getId()));
    }

}