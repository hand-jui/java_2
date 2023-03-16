package com.lhs;

import com.lhs.dao.AlbumDAO;
import com.lhs.dto.AlbumJsonDTO;
import com.lhs.json.JsonParser;

public class MainTest1 {
	public static void main(String[] args) {
		AlbumDAO dao = new AlbumDAO();
		String requestURL = "https://jsonplaceholder.typicode.com/albums/1";
		JsonParser<AlbumJsonDTO> jsonParser = new JsonParser<AlbumJsonDTO>(requestURL);
		AlbumJsonDTO resultJson = jsonParser.parsing(AlbumJsonDTO.class);
		int result = dao.insert(resultJson);
		if (result != 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}
}
