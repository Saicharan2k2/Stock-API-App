package com.example.stockservice.service;

import com.example.stockservice.dto.AlphaVantageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageService {
    @Value("${alpha.vantage.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public double getStockPrice(String symbol) {
        String url = String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=%s", symbol, apiKey);
        AlphaVantageResponse response = restTemplate.getForObject(url, AlphaVantageResponse.class);

        if (response != null && response.getGlobalQuote() != null) {
            return Double.parseDouble(response.getGlobalQuote().getPrice());
        }
        throw new RuntimeException("Failed to fetch stock price for symbol: " + symbol);
    }
}