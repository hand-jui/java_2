package noticeBoard.controller;

import java.util.ArrayList;

import noticeBoard.dto.DTO;
import noticeBoard.service.Service;

public class Controller {

	private Service service;

	public Controller() {
		service = new Service();
	}

	public ArrayList<DTO> select() {
		ArrayList<DTO> noticeList = new ArrayList<>();
		noticeList = service.select();
		return noticeList;
	}

	public int post(String title, String content, String nickname, String password) {
		int result = service.post(title, content, nickname, password);
		return result;
	}

	public int edit(String title, String content) {
		int result = service.edit(title, content);
		return result;
	}

}
