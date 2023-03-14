package com.tenco2.blog.controller;

import com.tenco2.blog.dto.UserDTO;
import com.tenco2.blog.service.UserService;

public class UserController {

	private UserService userService;

	public UserController() {
		userService = new UserService();
	}

	public UserDTO select(int userId) {

		return userService.select(userId);

	}
}
