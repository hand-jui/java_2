package com.jui.myblog;

import com.jui.myblog.controller.UserController;
import com.jui.myblog.dto.UserDTO;

public class MainTest {

	public static void main(String[] args) {

		UserDTO userDTO = new UserDTO("김체채", "1414", "osdscc@email.com", "서울시");

		UserController userC = new UserController();

//		회원가입
//		String resultSignUp = userC.requestSignUp(userDTO, "localhost");
//		System.out.println(resultSignUp);

//		로그인
		UserDTO responseUser = userC.requestSignIn(userDTO.getUsername(), userDTO.getPassword());
		if (responseUser == null) {
			System.out.println("로그인 실패");
		} else {
			System.out.println("로그인 성공");
		}
	} // end of main

} // end of class
