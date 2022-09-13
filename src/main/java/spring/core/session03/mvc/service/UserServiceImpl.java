package spring.core.session03.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.core.session03.mvc.model.User;
import spring.core.session03.mvc.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired // 自動綁定: 自動尋找有實作 UserDao 介面的類別, 並且建立該類別的實體物件
	           // 以本案來說會自動找到 UserDaoImpl 類別, 並且自動透過 new UserDaoImpl() 建立物件
	private UserDao userDao;
	
	@Override
	public void append(User user) {
		// 驗證 user 資料 ... 略
		System.out.println("Service - append user: " + user);
		// 新增 user
		userDao.add(user);
	}

	@Override
	public List<User> queryAll() {
		return userDao.findAll(); // 查詢 user
	}
	
}
