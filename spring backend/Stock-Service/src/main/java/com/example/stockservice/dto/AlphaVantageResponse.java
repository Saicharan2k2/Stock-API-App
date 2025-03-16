package com.example.stockservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlphaVantageResponse {
	@JsonProperty("Global Quote")
	private GlobalQuote globalQuote;

	public GlobalQuote getGlobalQuote() {
		return globalQuote;
	}

	public void setGlobalQuote(GlobalQuote globalQuote) {
		this.globalQuote = globalQuote;
	}

	public static class GlobalQuote {

		@JsonProperty("05. price")
		private String price;

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

	}
}