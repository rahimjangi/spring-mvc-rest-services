package com.raiseup.smrs.api.web.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Entity
public class BeerDto {
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

    public BeerDto() {
    }

    public BeerDto(Integer version, OffsetDateTime createDate, OffsetDateTime lastModifiedDate, String beerName, BearStyleEnum beerStyle, Long upc, BigDecimal price) {
        this.version = version;
        this.createDate = createDate;
        this.lastModifiedDate = lastModifiedDate;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public BearStyleEnum getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(BearStyleEnum beerStyle) {
        this.beerStyle = beerStyle;
    }

    public Long getUpc() {
        return upc;
    }

    public void setUpc(Long upc) {
        this.upc = upc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
