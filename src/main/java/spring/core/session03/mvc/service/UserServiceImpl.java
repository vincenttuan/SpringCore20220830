package spring.core.session03.mvc.service;

import java.util.List;

import spring.core.session03.mvc.model.User;

public class UserServiceImpl implements UserService {
	
	
	@Override
	public void append(User user) {
		// 驗證 user 資料 ... 略
		System.out.println("Service - append user: " + user);
		
	}

	@Override
	public List<User> queryAll() {
		return null;
	}
	
}
