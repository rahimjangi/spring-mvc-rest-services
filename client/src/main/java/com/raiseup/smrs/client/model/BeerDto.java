package com.raiseup.smrs.client.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BeerDto {

    @Null
    private Long id;

    private Integer version;
    private OffsetDateTime createDate;
    private OffsetDateTime lastModifiedDate;
    private String beerName;
    private BearStyleEnum beerStyle;
    @NotBlank
    @Positive
    private Long upc;
    @Positive
    @NotBlank
    private BigDecimal price;
}
