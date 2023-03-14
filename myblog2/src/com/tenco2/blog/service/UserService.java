package com.tenco2.blog.service;

import com.tenco2.blog.dao.UserDao;
import com.tenco2.blog.dto.UserDTO;

public class UserService {

	private UserDao userDao;

	public UserService() {
		userDao = new UserDao();
	}

	public UserDTO select(int userId) {

		return userDao.select(userId);
	}

}
