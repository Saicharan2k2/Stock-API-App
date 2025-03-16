package com.example.historyservice.controller;

import com.example.historyservice.model.StockPrice;
import com.example.historyservice.repository.StockPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private StockPriceRepository stockPriceRepository;

    @PostMapping
    public StockPrice saveStockPrice(@RequestParam String symbol, @RequestParam double price) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.setSymbol(symbol);
        stockPrice.setPrice(price);
        stockPrice.setTimestamp(LocalDateTime.now());
        return stockPriceRepository.save(stockPrice);
    }

    @GetMapping
    public List<StockPrice> getStockPriceHistory() {
        return stockPriceRepository.findAll();
    }
}