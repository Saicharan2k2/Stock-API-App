package com.example.stockservice.controller;

import com.example.stockservice.service.AlphaVantageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(origins = "http://localhost:3000")
public class StockController {
    @Autowired
    private AlphaVantageService alphaVantageService;

    @GetMapping("/{symbol}")
    public double getStockPrice(@PathVariable String symbol) {
        return alphaVantageService.getStockPrice(symbol);
    }
}