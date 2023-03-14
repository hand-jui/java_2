package com.jui.myblog.service;

import com.jui.myblog.dao.UserDAO;
import com.jui.myblog.dto.UserDTO;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

//	중복된 이름 찾는 로직
	public UserDTO selectByUserName(String username) {
		UserDTO resultDTO = userDAO.select(username);
		return resultDTO;
	}

//	회원가입
	public String signUp(UserDTO user) {
		String msg = "";
		UserDTO userDTO = selectByUserName(user.getUsername());
		if (user.getUsername().equals("")) {
			msg = "사용자 이름을 입력해주세요";
			System.out.println(msg);
			return msg;
		}
		user.setUserRole("USER");
		int resultRow = userDAO.saveUser(user);
		return resultRow + "";
	}

	public UserDTO checkUser(String username, String password) {
		boolean isValid = true;
		if(username.equals("")) {
			isValid = false;
		} else if(password.equals("")) {
			isValid = false;
		}
		UserDTO userDTO = null;
		if(isValid) {
			userDTO = userDAO.selectUserByusernameANDpassword(username, password);
		}
	return userDTO;
	}

}
