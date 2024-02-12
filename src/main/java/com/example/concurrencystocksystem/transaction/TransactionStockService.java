package com.example.concurrencystocksystem.transaction;

import com.example.concurrencystocksystem.service.StockService;

public class TransactionStockService {

	private StockService stockService;

	public TransactionStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public void decrease(Long id, Long quantity) {
		// * Even using synchronized keyword, test case won't pass, because of the transaction.
		startTransaction();

		this.stockService.decrease(id, quantity);

		// * Another thread could call decrease method again before commit.
		// * So same issue occurs.
		endTransaction();

		// * So remove @Transactional annotation when using synchronized keyword.
	}


	private void startTransaction() {
		System.out.println("start");
	}

	private void endTransaction() {
		System.out.println("end");
	}
}
