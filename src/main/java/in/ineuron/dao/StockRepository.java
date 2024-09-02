package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}
