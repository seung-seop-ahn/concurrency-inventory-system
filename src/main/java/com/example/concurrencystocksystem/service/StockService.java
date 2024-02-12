package com.example.concurrencystocksystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.concurrencystocksystem.domain.Stock;
import com.example.concurrencystocksystem.repository.StockRepository;

@Service
public class StockService {

	private final StockRepository stockRepository;

	public StockService(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	// public synchronized void decrease(Long id, Long quantity) {
	// 	Stock stock = this.stockRepository.findById(id).orElseThrow();
	// 	stock.decrease(quantity);
	//
	// 	this.stockRepository.saveAndFlush(stock);
	// }

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void decrease(Long id, Long quantity) {
		Stock stock = this.stockRepository.findById(id).orElseThrow();
		stock.decrease(quantity);

		this.stockRepository.saveAndFlush(stock);
	}
}
