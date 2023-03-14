package com.tenco.myblog;

import com.tenco.myblog.controller.BlogController;
import com.tenco.myblog.dto.BlogDTO;
import com.tenco.myblog.utils.DBHelper;

public class MainTest1 {

	public static void main(String[] args) {

//		코드테스트
//		DBHelper dbHelper = DBHelper.getInstance();
//		dbHelper.getConnection();
//		System.out.println("main에서 주소값 찍음 : " + dbHelper);
		
//		코드테스트
		BlogController blogController = new BlogController();
//		BlogDTO dto = blogController.requestBoardContentById(30);
//		System.out.println(dto);
		
		int result = blogController.requestDeleteBoardById(30, 3);
		System.out.println(result);

	}

}
