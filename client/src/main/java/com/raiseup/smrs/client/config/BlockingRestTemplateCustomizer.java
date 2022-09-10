package com.raiseup.smrs.client.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {


    private final Integer MAX_TOTAL_CONNECTIONS;
    private final Integer DEFAULT_MAX_PER_ROUTE;
    private final Integer CONNECTION_REQUEST_TIMEOUT;
    private final Integer SOCKET_TIMEOUT;

    public BlockingRestTemplateCustomizer(
            @Value("${com.raiseup.smrs.max_total_connections}") Integer max_total_connections,
            @Value("${com.raiseup.smrs.defaultmaxperroute}") Integer default_max_per_route,
            @Value("${com.raiseup.smrs.connectionrequesttimeout}") Integer connection_request_timeout,
            @Value("${com.raiseup.smrs.sockettimeout}") Integer socket_timeout) {
        MAX_TOTAL_CONNECTIONS = max_total_connections;
        DEFAULT_MAX_PER_ROUTE = default_max_per_route;
        CONNECTION_REQUEST_TIMEOUT = connection_request_timeout;
        SOCKET_TIMEOUT = socket_timeout;
    }

    public ClientHttpRequestFactory clientHttpRequestFactory(){
        PoolingHttpClientConnectionManager connectionManager=new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
        connectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUTE);
        RequestConfig requestConfig=RequestConfig
                .custom()
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        CloseableHttpClient httpClient= HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
