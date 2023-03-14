package com.tenco.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tenco.myblog.dto.BlogDTO;
import com.tenco.myblog.utils.DBHelper;

public class BlogDAO implements IBlogDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BlogDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public void select() {

	}

	@Override
	public BlogDTO select(int id) {
		BlogDTO blogDTO = null;
		String query = " SELECT * FROM board WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				blogDTO = new BlogDTO();
				blogDTO.setId(rs.getInt("id"));
				blogDTO.setTitle(rs.getString("title"));
				blogDTO.setContent(rs.getString("content"));
				blogDTO.setReadCount(rs.getInt("readCount"));
				blogDTO.setUserId(rs.getInt("userId"));
			}
		} catch (Exception e) {
			System.out.println("blogDAO select(int id) 에러 발생");
			e.printStackTrace();
		}
		return blogDTO;
	}

	@Override
	public int delete(int boardId) {
		int resultRow = 0;
		String sql = " DELETE FROM board WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(">> BlogDAO delete 에러 발생 <<");
			e.printStackTrace();
		}
		return resultRow;
	}
}
