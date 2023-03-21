package noticeBoard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import noticeBoard.controller.Controller;
import noticeBoard.dto.DTO;
import noticeBoard.utils.DBHelper;

public class DAO implements IDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public DAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public ArrayList<DTO> select() {
		ArrayList<DTO> noticeList = new ArrayList<>();
		String query = " SELECT no, title, nickname FROM noticeBoard ";
		try {
			rs = conn.prepareStatement(query).executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String nickname = rs.getString("nickname");
				DTO dto = new DTO();
				dto.setNo(no);
				dto.setTitle(title);
				dto.setNickname(nickname);
				noticeList.add(dto);
			}
		} catch (Exception e) {
			System.err.println("DAO select 에러");
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public DTO selectByNo(int no) {
		DTO dto = new DTO();
		String query = " SELECT * FROM noticeBoard WHERE no = ?  ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no + 1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String nickname = rs.getString("nickname");
				String password = rs.getString("password");
				dto.setNo(no);
				dto.setTitle(title);
				dto.setContent(content);
				dto.setNickname(nickname);
				dto.setPassword(password);
			}
		} catch (Exception e) {
			System.err.println("DAO select 에러");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int insert(DTO dto) {
		int resultRow = 0;
		String query = " INSERT INTO noticeBoard(title, content, nickname, password) VALUE (? , ?, ?, ?) ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getPassword());
			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("DAO insert 에러");
			e.printStackTrace();
		}
		return resultRow;
	}

	@Override
	public int update(DTO dto) {
		int resultRow = 0;
		String query = " UPDATE noticeBoard SET title = ? , content=? WHERE nickname = ? AND password = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getPassword());
			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("DAO update 에러");
			e.printStackTrace();
		}
		return resultRow;
	}

	@Override
	public int delete(DTO dto) {
		int resultRow = 0;
		String query = " DELETE FROM noticeBoard WHERE nickname= ? AND password = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getPassword());
			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("DAO delete 에러");
			e.printStackTrace();
		}
		return resultRow;
	}

//	public void insert(Controller controller) {
//		// TODO Auto-generated method stub
//		
//	}

} // end of class
