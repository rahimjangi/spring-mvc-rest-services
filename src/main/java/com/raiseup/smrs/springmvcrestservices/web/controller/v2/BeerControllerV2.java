package com.raiseup.smrs.springmvcrestservices.web.controller.v2;

import com.raiseup.smrs.springmvcrestservices.service.BeerService;
import com.raiseup.smrs.springmvcrestservices.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v2/beer")
@RequiredArgsConstructor
public class BeerControllerV2 {

    private final BeerService beerService;

    @GetMapping
    public ResponseEntity<List<BeerDto>>getBeers(){
        return new ResponseEntity<>(beerService.findAll(),HttpStatus.OK);
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto>getBeer(@PathVariable("beerId") String beerId){
        log.info("beerId: {}",beerId);
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto>createBeer(@RequestBody BeerDto beer){
        return new ResponseEntity<>(beerService.create(beer),HttpStatus.ACCEPTED);
    }
}
