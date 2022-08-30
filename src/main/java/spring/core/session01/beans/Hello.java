package spring.core.session01.beans;

import java.util.Date;

public class Hello {
	
	Date today = new Date();

	@Override
	public String toString() {
		return "Hello [today=" + today + "]";
	}

}
