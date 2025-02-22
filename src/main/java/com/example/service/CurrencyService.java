package com.example.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exception.CurrencyNotFoundException;
import com.example.exception.ExternalApiException;
import com.example.model.ConversionRequest;
import com.example.model.ConversionResponse;
import com.example.model.ExchangeRateResponse;

@Service
public class CurrencyService {

	@Autowired
	private ExchangeRateClient exchangeRateClient;

	public ExchangeRateResponse getRates(String base) {
		try {
			return exchangeRateClient.getExchangeRates(base);
		} catch (ExternalApiException e) {
			// Return a default error response instead of crashing the application
			return new ExchangeRateResponse();
		}
	}

	

	public ConversionResponse convert(ConversionRequest request) {
		ExchangeRateResponse rates = exchangeRateClient.getExchangeRates(request.getFrom());

		if (!rates.getConversion_rates().containsKey(request.getTo())) {
			throw new CurrencyNotFoundException("Invalid currency code: " + request.getTo());
		}

		double rate = rates.getConversion_rates().get(request.getTo());
		double convertedAmount = request.getAmount() * rate;

		return new ConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
	}
}