package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StockHistory;

@Repository
public interface StockHistoryRepository extends JpaRepository<StockHistory, Long> {

}
