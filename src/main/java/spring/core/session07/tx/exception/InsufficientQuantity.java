package spring.core.session07.tx.exception;

// 庫存數量不足例外
public class InsufficientQuantity extends Exception {
	public InsufficientQuantity(String errorMessage) {
		super(errorMessage);
	}
}
