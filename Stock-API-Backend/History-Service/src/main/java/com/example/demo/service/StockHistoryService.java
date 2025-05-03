package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StockHistory;
import com.example.demo.repository.StockHistoryRepository;

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
