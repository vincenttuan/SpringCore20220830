package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientQuantity;

@Service
public class ManyBookServiceImpl implements ManyBookService {
	
	@Autowired
	private BookService bookService;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientQuantity, InsufficientAmount {
		
		for(Integer bid : bids) {
			bookService.buyOne(wid, bid);
		}
		
	}
	
	
}
