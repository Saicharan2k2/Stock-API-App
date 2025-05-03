package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "stock_history")
public class StockHistory {

	private String symbol;
	private String name;
	private Double open;
	private Double high;
	private Double low;
	private Double price;
	private Double previousClose;
	private Long volume;

	public StockHistory() {
		
	}

	public StockHistory(Long id, String symbol, String name, Double open, Double high, Double low, Double price,
			Double previousClose, Long volume) {
		this.id = id;
		this.symbol = symbol;
		this.name = name;
		this.open = open;
		this.high = high;
		this.low = low;
		this.price = price;
		this.previousClose = previousClose;
		this.volume = volume;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(Double previousClose) {
		this.previousClose = previousClose;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}
}
