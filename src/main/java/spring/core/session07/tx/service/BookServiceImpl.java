package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.core.session07.tx.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	
	/*
	 * Propagation.REQUIRED     : 如果有事務在運行, 當前方法就在該事物中運行, 
	 *                            否則就啟動一個新的事物, 並在自己的事物運行
	 * Propagation.REQUIRES_NEW : 當前方法必須啟動一個新的事物, 並在自己的事物運行
	 *                            如果之前有事務正在運行, 就會將他掛起不用
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyOne(Integer wid, Integer bid) {
		// 1. 減去庫存
		bookDao.updateStock(bid, 1); // 減去一本庫存
		// 2. 減去餘額
		Integer bookPrice = bookDao.getBookPrice(bid); // 取得該書本的價格
		bookDao.updateWallet(wid, bookPrice); // 更新錢包金額
	}
	
}
