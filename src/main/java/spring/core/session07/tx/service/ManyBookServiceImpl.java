package spring.core.session07.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManyBookServiceImpl implements ManyBookService {
	
	@Autowired
	private BookService bookService;
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void buyMany(Integer wid, Integer... bids) {
		
		for(Integer bid : bids) {
			bookService.buyOne(wid, bid);
		}
		
	}
	
	
}
