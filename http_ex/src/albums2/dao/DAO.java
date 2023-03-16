package albums2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import albums2.dto.DTO;
import albums2.utils.DBHelper;

public class DAO implements IDAO {

	private Connection conn;
	private PreparedStatement pstmt;

	public DAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public int insert(DTO[] dto) {
		int resultRow = 0;
		int dtoSize = dto.length;
		String sql = " INSERT INTO albums(userId, id, title) VALUES ";
		for (int i = 0; i < dtoSize; i++) {
			if (i == dtoSize - 1) {
				sql += " (?, ?, ?) ";
				break;
			}
			sql += " (?, ?, ?), ";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			int n = 0;
			for (int i = 0; i < dtoSize; i++) {
				pstmt.setInt(n + 1, dto[i].getUserId());
				pstmt.setInt(n+2,	dto[i].getId());
				pstmt.setString(n + 2, dto[i].getTitle());
				n += 3;
			}
			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultRow;
	}

}
