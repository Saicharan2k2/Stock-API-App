package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StockHistory;
import com.example.demo.repository.StockHistoryService;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
public class StockHistoryController {

	@Autowired
	private StockHistoryService stockHistoryService;

	@PostMapping("/save")
	public StockHistory saveStockHistory(@RequestBody StockHistory stockHistory) {
		return stockHistoryService.saveStock(stockHistory);
	}

	@GetMapping("/all")
	public List<StockHistory> getAllHistory() {
		return stockHistoryService.getAllHistory();
	}

}
