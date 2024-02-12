package com.example.concurrencystocksystem.service;

import org.springframework.stereotype.Service;

import com.example.concurrencystocksystem.domain.Stock;
import com.example.concurrencystocksystem.repository.StockRepository;

import jakarta.transaction.Transactional;

@Service
public class OptimisticLockStockService {

	private final StockRepository stockRepository;

	public OptimisticLockStockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	@Transactional
	public void decrease(Long id, Long quantity) {
		Stock stock = this.stockRepository.findByIdWithOptimisticLock(id);

		stock.decrease(quantity);

		this.stockRepository.save(stock);
	}
}
