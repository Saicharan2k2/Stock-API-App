package in.ineuron.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

//import java.util.List;
//
//import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import in.ineuron.entity.Stock;
import in.ineuron.service.StockService;

@RestController
@RequestMapping("/stocks")
@CrossOrigin(origins = "http://localhost:3000")
public class StockController {
	
//	@Autowired
	private StockService stockService;
	
//	@GetMapping
//	public List<Stock> getAllStocks(){
//		return stockService.getAllStocks();
//	}
//	
//	@GetMapping("/{id}")
//	public Optional<Stock> getStockById(@PathVariable Long id){
//		return stockService.getStockById(id);
//	}
//	
//	@PostMapping
//	public Stock saveStock(@RequestBody Stock stock) {
//		return stockService.saveStock(stock);
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteStock(Long id) {
//		stockService.deleteStock(id);
//	}
	
	public StockController(StockService stockService) {
		this.stockService=stockService;
	}
	
	@GetMapping("/{symbol}")
	public String getStock(@PathVariable String symbol) {
		return stockService.getStockData(symbol);
	}
}
