package model.service;

import java.sql.SQLException;

import dto.User;
import model.dao.UserDao;

public class UserService {
	// 싱글톤
	public UserService() {
	}

	private static UserService instance = new UserService();

	public static UserService getInstance() {
		return instance;
	}

	UserDao userDao = UserDao.getInstance();

	// 로그인
	public boolean login(User user) throws SQLException {
		return userDao.findUser(user);

	}
}
