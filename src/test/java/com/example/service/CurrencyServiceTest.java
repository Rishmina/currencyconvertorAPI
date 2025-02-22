package com.example.service;



import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.example.model.ConversionRequest;
import com.example.model.ConversionResponse;
import com.example.model.ExchangeRateResponse;

class CurrencyServiceTest {

    @Test
    void testConvert() {
        CurrencyService service = new CurrencyService();
        ExchangeRateResponse rates = new ExchangeRateResponse();
        rates.setConversion_rates(Map.of("EUR", 0.94));

        ConversionRequest request = new ConversionRequest();
        request.setFrom("USD");
        request.setTo("EUR");
        request.setAmount(100);

        ConversionResponse response = service.convert(request);
        assertEquals(94.0, response.getConvertedAmount());
    }
}
