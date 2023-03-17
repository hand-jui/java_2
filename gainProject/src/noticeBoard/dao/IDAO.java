package noticeBoard.dao;

import java.util.ArrayList;

import noticeBoard.dto.DTO;

public interface IDAO {

	ArrayList<DTO> select();

	int insert(DTO dto);

	int update(DTO dto);

//	int delete(DTO dto);


}
