package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.StockResponse;
import com.example.demo.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(value = "/api/stocks/{symbol}", produces = "application/json")
    public ResponseEntity<StockResponse> getStock(@PathVariable String symbol) throws Exception {
        StockResponse stockData = stockService.getStockData(symbol);
        return ResponseEntity.ok(stockData);
    }
}
