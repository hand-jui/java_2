package com.tenco2.blog.dao;

import com.tenco2.blog.dto.UserDTO;

public class UserDao {

//	1. UserDTO를 만들어라
	public UserDTO select(int userId) {

//		UserDTO 객체를 임의의 값을 넣어 생성하고 그 결과를 main 함수에서 출력
		UserDTO kimUser = new UserDTO(1, "미스터김");
		return kimUser;
		
		
//		DB에 있는 부분을 연동하고 싶다면 
//		거기에 맞는 기술들을 알아보고 분석해서 준비 하면 된다.
		
//		MySQL <-- 데이터 관리 (다중 접속 가능)
//		드라이버..
		
//		추상화되어있는 Connection 객체가 필요하다
//		주소, 계정, 비번, 데이터베이스 이름, 포트번호, 사용할 문자셋, 현지 시간
//		접근해서 활동 가능한 부분들이 Connection 이라는 객체 안에 담겨져 있다
	
//		Connection 에서 연결처리 외에 많이 하는 작업은
//		SQL을 만들고 실행하는 일이다
//		SQL 질의어를 만들기 위해선 Statement 객체가 필요
		
//		connection 객체에서 Statement, PrepareStatement를 생성할 수 있다
//		connection.createStatement() 또는 
//		connection.preparedStatement 를 사용할 수 있다.
//		? ? 에 값을 바인딩 하는 기능
		
//		prepareStatement 질의어를 생성하고 질의어를 실행시킬 수 있다
//		select <-- executeQuery() 사용
//		delete, update, insert <-- executeUpdate() 사ㅇ용
		
//		쿼리를 실행하면 결과값은
//		executeQuery() --> ResultSet 반환
//		executeUpdate() --> 질의어 Row 반환
		
		
		
		
		
	}

}
