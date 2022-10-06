package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
	 * Propagation.SUPPORTS     : 如果有事務在運行, 當前方法就在此事務中運行, 否則就不再事務中運行
	 * Propagation.NOTSUPPORTED : 當前方法不應該在事務中運行, 如果有事務就會將它掛起不用
	 * Propagation.MANDATORY    : 當前方法必須在運行在事務中, 若沒有就拋出異常
	 * Propagation.NEVER        : 當前方法不應該運行在事務中, 若在事務中就拋出異常
	 * Propagation.NESTED       : 如果有事務在運行, 當前方法必須嵌套在事務中, 否則就啟動一個新事務並在自己的事務中運行
	 * 
	 * Isolation 事務的隔離級別, 在併發的情況下, 操作數據 CRUD 的一種規則
	 * Isolation.DEFAULT: 預設, MySQL預設是(Isolation.REPEATABLE_READ 可重複讀)
	 * Isolation.READ_UNCOMMITTED 讀未提交: 髒讀 (針對欄位資料)
	 * Isolation.READ_COMMITTED 讀已提交: 不可重複讀 (針對欄位資料)
	 * Isolation.REPEATABLE_READ 可重複讀: 幻讀, 其他人不可以針對指定資料列RUD (針對欄位列)
	 * Isolation.SERIALIZABLE 序列化: 效能低, 消耗大, 但是可以簡單解決上面的問題(實務上不建議使用) 
	 * */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
	@Override
	public void buyOne(Integer wid, Integer bid) {
		// 1. 減去庫存
		bookDao.updateStock(bid, 1); // 減去一本庫存
		// 2. 減去餘額
		Integer bookPrice = bookDao.getBookPrice(bid); // 取得該書本的價格
		bookDao.updateWallet(wid, bookPrice); // 更新錢包金額
	}
	
}



