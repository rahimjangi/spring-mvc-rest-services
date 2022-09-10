package com.raiseup.smrs.api.entity;

import com.raiseup.smrs.api.web.model.BearStyleEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Slf4j
@Data
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Integer version;
    @CreationTimestamp
    @Column(updatable = false)
    private OffsetDateTime createDate;
    @UpdateTimestamp
    private OffsetDateTime lastModifiedDate;
    @Column(length = 50,nullable = false)
    @Length(min = 3,max = 20,message = "Min = 3 and Max=20")
    private String beerName;
    private BearStyleEnum beerStyle;
    @Column(unique = true)
    @Positive
    private Long upc;
    private BigDecimal price;
}
