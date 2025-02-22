package com.example.controller;

import com.example.model.ConversionRequest;
import com.example.model.ConversionResponse;
import com.example.model.ExchangeRateResponse;
import com.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public ExchangeRateResponse getRates(@RequestParam(defaultValue = "USD") String base) {
        return currencyService.getRates(base);
    }

    @PostMapping("/convert")
    public ConversionResponse convert(@RequestBody ConversionRequest request) {
        return currencyService.convert(request);
    }
}
