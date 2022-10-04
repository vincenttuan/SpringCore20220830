package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.core.session07.tx.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	public void buyOne(Integer wid, Integer bid) {
		// 1. 減去庫存
		bookDao.updateStock(bid, 1); // 減去一本庫存
		// 2. 減去餘額
		Integer bookPrice = bookDao.getBookPrice(bid); // 取得該書本的價格
		bookDao.updateWallet(wid, bookPrice); // 更新錢包金額
	}
	
}
