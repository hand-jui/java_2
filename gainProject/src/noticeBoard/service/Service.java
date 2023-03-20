package noticeBoard.service;

import java.util.ArrayList;

import noticeBoard.dao.DAO;
import noticeBoard.dto.DTO;

public class Service {

	private DAO dao;

	public Service() {
		dao = new DAO();
	}

	public ArrayList<DTO> select() {
		ArrayList<DTO> noticeDto = new ArrayList<>();
		noticeDto = dao.select();
		return noticeDto;
	}

	public int post(String title, String content, String nickname, String password) {
		int result = 0;
		DTO dto = new DTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setNickname(nickname);
		dto.setPassword(password);
		result = dao.insert(dto);
		return result;
	}
	
	public int edit(String title,String content) {
		int result = 0;
		DTO dto = new DTO();
		dto.setTitle(title);
		dto.setContent(content);
		result = dao.update(dto);
		return result;
	}

}
