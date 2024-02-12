package com.example.concurrencystocksystem.facade;

import java.util.concurrent.TimeUnit;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import com.example.concurrencystocksystem.service.StockService;

@Component
public class RedissonLockStockFacade {

	private final RedissonClient redissonClient;

	private final StockService stockService;

	public RedissonLockStockFacade(RedissonClient redissonClient, StockService stockService) {
		this.redissonClient = redissonClient;
		this.stockService = stockService;
	}

	public void decrease(Long id, Long quantity) {
		RLock lock = this.redissonClient.getLock(id.toString());

		try {
			boolean available = lock.tryLock(10, 1, TimeUnit.SECONDS);

			if(!available) {
				System.out.println("lock acquisition failed");
			}

			this.stockService.decrease(id, quantity);

		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} finally {
			lock.unlock();
		}
	}
}
