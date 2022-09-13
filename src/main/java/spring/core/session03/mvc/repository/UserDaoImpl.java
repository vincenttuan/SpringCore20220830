package spring.core.session03.mvc.repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import spring.core.session03.mvc.model.User;

public class UserDaoImpl implements UserDao {
	
	private List<User> users = new CopyOnWriteArrayList<>();
	
	@Override
	public void add(User user) {
		System.out.println("加入: " + user);
		users.add(user);
	}

	@Override
	public List<User> findAll() {
		return users;
	}

}
