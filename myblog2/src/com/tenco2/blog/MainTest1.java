package com.tenco2.blog;

import com.tenco2.blog.controller.AController;
import com.tenco2.blog.controller.UserController;
import com.tenco2.blog.dto.UserDTO;

public class MainTest1 {

	public static void main(String[] args) {

//		select();
		
//		main -> AC -> AS -> AD
//		결과 받아보기
		
//		AController aController = new AController();
//		String acResult = aController.select("not null");
//		System.out.println(acResult);
		
//		2.
//		2-1.
//		2-1.
//		2-1.
//		2-1.
//		2-1.
		UserController userController = new UserController();
		UserDTO reponseDTO = userController.select(1);
		System.out.println(reponseDTO);
		
		
		
	}

}
