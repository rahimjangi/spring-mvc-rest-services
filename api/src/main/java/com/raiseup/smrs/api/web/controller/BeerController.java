package com.raiseup.smrs.api.web.controller;

import com.raiseup.smrs.api.service.BeerService;
import com.raiseup.smrs.api.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping({"/api/v1/beer"})
@RequiredArgsConstructor
@Slf4j
public class BeerController {

    private final BeerService beerService;

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto>getBeerById(@PathVariable("beerId")Long beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto>saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        return new ResponseEntity<>(beerService.create(beerDto),HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto>updateBeer(@Valid @RequestBody BeerDto beerDto,@PathVariable Long beerId){
        return new ResponseEntity<>(beerService.update(beerId,beerDto),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    public void deleteBeer(@PathVariable("beerId")Long beerId){
        beerService.deleteBeerById(beerId);
        log.info("inside deleteBeer: {}",beerId);
    }



}
