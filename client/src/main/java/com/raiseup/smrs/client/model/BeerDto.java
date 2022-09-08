package com.raiseup.smrs.client.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BeerDto {

    private Long id;

    private Integer version;
    private OffsetDateTime createDate;
    private OffsetDateTime lastModifiedDate;
    private String beerName;
    private BearStyleEnum beerStyle;
    private Long upc;
    private BigDecimal price;
}
