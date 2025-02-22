package com.example.service;

import com.example.model.ExchangeRateResponse;
import com.example.exception.ExternalApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateClient {

    @Value("${exchange.rate.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public ExchangeRateResponse getExchangeRates(String base) {
        String url = apiUrl + base;
        try {
            return restTemplate.getForObject(url, ExchangeRateResponse.class);
        } catch (Exception e) {
            throw new ExternalApiException("Failed to fetch exchange rates.");
        }
    }
}
