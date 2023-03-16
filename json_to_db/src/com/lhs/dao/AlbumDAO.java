package com.lhs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lhs.dto.AlbumJsonDTO;
import com.lhs.util.DBHelper;

public class AlbumDAO implements IAlbumDAO {
	private DBHelper dbHelper;

	public AlbumDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int insert(AlbumJsonDTO albumDTO) {
		String sql = "INSERT INTO ALBUMS VALUES(?, ?, ?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, albumDTO.getUserId());
			pstmt.setInt(2, albumDTO.getId());
			pstmt.setString(3, albumDTO.getTitle());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL구문 에러");
		}
		return result;
	}

	public int insert(AlbumJsonDTO[] albumDTOList) {
		int size = albumDTOList.length;
		String sql = "INSERT INTO ALBUMS VALUES";
		for (int i = 0; i < size; i++) {
			if (i == size-1) {
				sql += "(?, ?, ?)";
				break;
			}
			sql += "(?, ?, ?), ";
		}
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < size; i++) {
				pstmt.setInt((i*3)+1, albumDTOList[i].getUserId());
				pstmt.setInt((i*3)+2, albumDTOList[i].getId());
				pstmt.setString((i*3)+3, albumDTOList[i].getTitle());
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL구문 에러");
		}
		return result;
	}

}
