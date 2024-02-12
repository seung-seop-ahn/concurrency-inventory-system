package com.example.concurrencystocksystem.facade;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.concurrencystocksystem.repository.LockRepository;
import com.example.concurrencystocksystem.service.StockService;


@Component
public class NamedLockStockFacade {

	private final LockRepository lockRepository;

	private final StockService stockService;

	public NamedLockStockFacade(LockRepository lockRepository, StockService stockService) {
		this.lockRepository = lockRepository;
		this.stockService = stockService;
	}

	@Transactional
	public void decrease(Long id, Long quantity) {
		try {
			this.lockRepository.getLock(id.toString());
			this.stockService.decrease(id, quantity);
		} finally {
			this.lockRepository.releaseLock(id.toString());
		}
	}
}
