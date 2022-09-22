package spring.core.session05.aop_lab;

import org.springframework.stereotype.Component;

@Component
public class BackSinger implements Singer {

	@Override
	public void sing() {
		System.out.println("啦啦啦~~~");
	}
	
}
