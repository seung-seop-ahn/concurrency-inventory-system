package com.example.concurrencystocksystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.concurrencystocksystem.domain.Stock;
import com.example.concurrencystocksystem.repository.StockRepository;

@SpringBootTest
class StockServiceTest {

	@Autowired
	private StockService stockService;

	@Autowired
	private StockRepository stockRepository;

	@BeforeEach
	public void before() {
		this.stockRepository.saveAndFlush(new Stock(1L, 100L));
	}

	@AfterEach
	public void after() {
		this.stockRepository.deleteAll();
	}

	@Test
	public void decreaseQuantity() {
		this.stockService.decrease(1L, 1L);

		Stock stock = this.stockRepository.findById(1L).orElseThrow();

		assertEquals(99, stock.getQuantity());
	}

}