package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StockHistory;

@Service
public class StockHistoryService {

	@Autowired
	private StockHistoryRepository stockHistoryRepository;

	public StockHistory saveStock(StockHistory stockHistory) {
		return stockHistoryRepository.save(stockHistory);
	}

	public List<StockHistory> getAllHistory() {
		return stockHistoryRepository.findAll();
	}

}
