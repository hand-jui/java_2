package com.jui.myblog.controller;

import com.jui.myblog.dto.UserDTO;
import com.jui.myblog.service.UserService;

public class UserController {

	private UserService userS;

	public UserController() {
		userS = new UserService();
	}

	public String requestSignUp(UserDTO user, String host) {
		String response = "외부에서는 회원가입이 불가합니다.";
		if (host.equals("localhost")) {
			response = userS.signUp(user);
		}
		return response;
	}

	public UserDTO requestSignIn(String username, String password) {
		UserDTO responseDTO = userS.checkUser(username, password);
		return responseDTO;
	}

}
