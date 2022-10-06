package spring.core.session07.tx.service;

import spring.core.session07.tx.exception.InsufficientAmount;
import spring.core.session07.tx.exception.InsufficientQuantity;

public interface ManyBookService {
	void buyMany(Integer wid, Integer... bids) throws InsufficientQuantity, InsufficientAmount;
}
