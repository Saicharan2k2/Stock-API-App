package com.example.demo.model;

public class StockResponse {

	private String companyName;
	private String symbol;
	private String open;
	private String high;
	private String low;
	private String price;
	private String previousClose;
	private String volume;

	public StockResponse() {
	}

	public StockResponse(String symbol, String open, String high, String low, String price, String previousClose,
			String volume) {
		this.symbol = symbol;
		this.open = open;
		this.high = high;
		this.low = low;
		this.price = price;
		this.previousClose = previousClose;
		this.volume = volume;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(String previousClose) {
		this.previousClose = previousClose;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
}