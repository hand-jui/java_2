package albums2.controller;

import albums2.dto.DTO;
import albums2.service.Service;

public class Controller {
	
	private Service service;
	
	public Controller() {
		service = new Service();
	}
	
	public int saveTitle(DTO[] dto) {
		int resultRow = 0;
		resultRow = service.save(dto);
			
		return resultRow;
	}

}
