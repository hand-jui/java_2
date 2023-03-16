package albums2.service;

import albums2.dao.DAO;
import albums2.dto.DTO;

public class Service {

	private DAO dao;

	public Service() {
		dao = new DAO();
	}

	public int save(DTO[] dto) {
		int resultRow = dao.insert(dto);
		return resultRow;
	}

}
