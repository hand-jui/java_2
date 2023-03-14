package com.tenco.myblog.service;

import com.tenco.myblog.dao.BlogDAO;
import com.tenco.myblog.dto.BlogDTO;

public class BlogService {

	private BlogDAO blogDAO;

	public BlogService() {
		blogDAO = new BlogDAO();
	}

//	하나의 게시글 찾는 로직
	public BlogDTO selectByBoardId(int id) {
		BlogDTO resultDTO = blogDAO.select(id);
		return resultDTO;
	}

	public int deleteBoardById(int boardId, int userId) {
		int resultRow = 0;
//		검증 userId 값과 board 테이블에 있는 작성자의 userId 값이 같은지 확인
		BlogDTO blogDTO = selectByBoardId(boardId);
//		blogDTO가 null 일 때 방어적 코드
		if (blogDTO != null) {
			int blogWriterId = blogDTO.getUserId();
			if (blogWriterId == userId) {
//			삭제 요청가능 아니라면 0 반환
//			삭제 요청 처리
				resultRow = blogDAO.delete(boardId);
			}
		}
		return resultRow;
	}
}
