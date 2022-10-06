package spring.core.session07.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientQuantity;
import spring.core.session07.tx.service.BookService;
import spring.core.session07.tx.service.ManyBookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ManyBookService manyBookService;
	
	public void buyOneBook(Integer wid, Integer bid) throws InsufficientQuantity, InsufficientAmount {
		bookService.buyOne(wid, bid);
		System.out.println("Buy one book OK !");
	}
	
	public void buyManyBooks(Integer wid, Integer... bids) throws InsufficientQuantity, InsufficientAmount {
		manyBookService.buyMany(wid, bids);
		System.out.println("Buy many books OK !");
	}
	
}
