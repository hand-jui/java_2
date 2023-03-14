package com.tenco2.blog.service;

import com.tenco2.blog.dao.ADao;

public class AService {
	
	private ADao aDao;
	
	public AService() {
		aDao = new ADao();
	}
	
	public String select(String msg) {
//		AS-->AC
		String result2 = aDao.select(msg);
		
		return result2;
	}

}
