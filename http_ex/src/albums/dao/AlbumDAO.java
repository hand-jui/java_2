package albums.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import albums.dto.AlbumDTO;
import albums.utils.DBHelper;

public class AlbumDAO implements IAlbumDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	public AlbumDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public int insert(AlbumDTO albumDTO) {
		int resultRowCount = 0;
		String query = " INSERT INTO albums(userId, title) VALUES (?, ?) ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, albumDTO.getUserId());
			pstmt.setString(2, albumDTO.getTitle());
			resultRowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DAO에서 insert 실행 오류");
			e.printStackTrace();
		}
		return resultRowCount;
	}

}