package com.example.demo.service;

import com.example.demo.model.StockResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class StockService {

    @Value("${api.key}")
    private String apiKey;
    private final RestTemplate restTemplate = new RestTemplate();

    public StockResponse getStockData(String symbol) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String searchUrl = "https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=" + symbol + "&apikey=" + apiKey;
        String searchResponse = restTemplate.getForObject(searchUrl, String.class);
        JsonNode searchRoot = mapper.readTree(searchResponse);

        String companyName = "Unknown Company";
        if (searchRoot.has("bestMatches") && searchRoot.get("bestMatches").size() > 0) {
            JsonNode bestMatch = searchRoot.get("bestMatches").get(0);
            companyName = bestMatch.get("2. name").asText();
        }

        String quoteUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey;
        String quoteResponse = restTemplate.getForObject(quoteUrl, String.class);
        JsonNode quoteRoot = mapper.readTree(quoteResponse);

        JsonNode globalQuote = quoteRoot.path("Global Quote");
        if (globalQuote.isMissingNode() || globalQuote.size() == 0) {
            throw new RuntimeException("Stock not found for symbol: " + symbol);
        }

        StockResponse stockResponse = new StockResponse();
        stockResponse.setSymbol(globalQuote.get("01. symbol").asText());
        stockResponse.setCompanyName(companyName);
        stockResponse.setOpen(globalQuote.get("02. open").asText());
        stockResponse.setHigh(globalQuote.get("03. high").asText());
        stockResponse.setLow(globalQuote.get("04. low").asText());
        stockResponse.setPrice(globalQuote.get("05. price").asText());
        stockResponse.setPreviousClose(globalQuote.get("08. previous close").asText());
        stockResponse.setVolume(globalQuote.get("06. volume").asText());

        return stockResponse;
    }
}
