package com.raiseup.smrs.springmvcrestservices.web.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Data
@Builder
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class BeerDto {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private Long upc;


}
