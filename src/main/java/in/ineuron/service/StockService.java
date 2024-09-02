package in.ineuron.service;

// import java.util.List;
// import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import in.ineuron.dao.StockRepository;
import in.ineuron.entity.Stock;

@Service
public class StockService {

	// @Autowired
	// private StockRepository stockrepo;
	
	// public List<Stock>getAllStocks(){
	// 	return stockrepo.findAll();
	// }
	
	// public Optional<Stock> getStockById(Long id){
	// 	return stockrepo.findById(id);
	// }
	
	// public Stock saveStock(Stock stock) {
	// 	return stockrepo.save(stock);
	// }
	
	// public void deleteStock(Long id) {
	// 	stockrepo.deleteById(id);
	// }

	@Value("${alphavantage.api.key}")
	private String apiKey;

	private final RestTemplate restTemplate;

	public StockService(RestTemplate restTemplate){
		this.restTemplate=restTemplate;
	}

	public String getStockData(String symbol){
		String url = UriComponentsBuilder
		.fromHttpUrl("https://www.alphavantage.co/query")
		.queryParam("function","TIME_SERIES_INTRADAY")
		.queryParam("symbol",symbol)
		.queryParam("interval","1min")
		.queryParam("apiKey",apiKey)
		.toUriString();
	return restTemplate.getForObject(url,String.class);
	}
}
