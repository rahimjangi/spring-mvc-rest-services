package com.raiseup.smrs.client.web.client;

import com.raiseup.smrs.client.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@ConfigurationProperties(value = "com.raiseup.smrs",ignoreUnknownFields = false)
@Slf4j
public class BeerClient {

    public final String BEER_PATH_V1="/api/v1/beer/";
    private String apihost;
    private final RestTemplate restTemplate;

    public BeerClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public BeerDto getBeerById(Long id){
        return restTemplate
                .getForObject(apihost+BEER_PATH_V1+id.toString(),BeerDto.class);
    }

    public BeerDto saveBeer(BeerDto beerDto){
        return restTemplate
                .postForObject(apihost+BEER_PATH_V1,beerDto,BeerDto.class);
    }

    public void updateBeer(Long id,BeerDto beerDto){
        restTemplate.put(apihost+BEER_PATH_V1+id.toString(),beerDto);
    }

    public void deleteBeer(Long id){
        log.info("ID to delete: {}",apihost+BEER_PATH_V1+id);
        restTemplate.delete(apihost+BEER_PATH_V1+id);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
