package com.raiseup.smrs.client.web.client;

import com.raiseup.smrs.client.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}