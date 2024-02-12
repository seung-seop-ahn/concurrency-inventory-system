package com.example.concurrencystocksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.concurrencystocksystem.domain.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
