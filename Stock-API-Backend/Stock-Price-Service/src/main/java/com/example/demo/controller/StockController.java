package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.StockResponse;
import com.example.demo.service.StockService;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "*")
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping(value = "/{symbol}", produces = "application/json")
	public ResponseEntity<StockResponse> getStock(@PathVariable String symbol) {
		try {
			StockResponse stockData = stockService.getStockData(symbol);
			return ResponseEntity.ok(stockData);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}