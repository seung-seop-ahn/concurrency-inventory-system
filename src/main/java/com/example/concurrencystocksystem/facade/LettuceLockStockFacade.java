package com.example.concurrencystocksystem.facade;

import org.springframework.stereotype.Component;

import com.example.concurrencystocksystem.repository.RedisLockRepository;
import com.example.concurrencystocksystem.service.StockService;

@Component
public class LettuceLockStockFacade {

	private final RedisLockRepository redisLockRepository;

	private final StockService stockService;

	public LettuceLockStockFacade(RedisLockRepository redisLockRepository, StockService stockService) {
		this.redisLockRepository = redisLockRepository;
		this.stockService = stockService;
	}

	public void decrease(Long id, Long quantity) throws InterruptedException {
		while (!this.redisLockRepository.lock(id)) {
			Thread.sleep(100);
		}

		try {
			this.stockService.decrease(id, quantity);
		} finally {
			this.redisLockRepository.unlock(id);
		}
	}
}
