package com.jui.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jui.myblog.dto.UserDTO;
import com.jui.myblog.utils.DBHelper;

public class UserDAO implements IUserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public int saveUser(UserDTO user) {
		int resultRow = 0;
		String query = " INSERT INTO user(username, password, email, address, userRole, createDate) "
				+ " VALUES(?, ?, ?, ?, ?, now()) ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4,user.getAddress());
			pstmt.setString(5,user.getUserRole());
			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("UserDAO save 에러 발생");
			e.printStackTrace();
		}
		return resultRow;
	}

	@Override
	public UserDTO select(String username) {
		UserDTO userDTO = null;
		String query = " SELECT * FROM user WHERE username = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				userDTO = new UserDTO();
				userDTO.setId(rs.getInt("id"));
				userDTO.setUsername(rs.getString("username"));
				userDTO.setPassword(rs.getString("password"));
				userDTO.setEmail(rs.getString("email"));
				userDTO.setUserRole(rs.getString("userRole"));
				userDTO.setCreateDate(rs.getString("createDate"));
			}
		} catch (Exception e) {
			System.out.println("UserDAO select(String username) 오류 발생");
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public UserDTO selectUserByusernameANDpassword(String username, String password) {
		UserDTO resultUser = null;
		String query = " SELECT * FROM user WHERE username = ? AND password = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getInt("Id"));
				dto.setUsername(rs.getString("username"));
				dto.setEmail(rs.getString("email"));
				resultUser = dto;
			}
		} catch (Exception e) {
			System.err.println("UserDAO select..(username,password) 오류 발생");
			e.printStackTrace();
		}
		return resultUser;
	}


	@Override
	public int deleteUserByusernameANDpassword(String username, String password) {
		int resultRow = 0;
		String query = " DELETE FROM user WHERE username = ? AND password = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("UserDAO delete 에러 발생");
			e.printStackTrace();
		}
		return resultRow;
	}

}
