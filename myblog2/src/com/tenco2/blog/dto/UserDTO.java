package com.tenco2.blog.dto;

public class UserDTO {

	private int id;
	private String userName;

	public UserDTO() {
	}

	public UserDTO(int id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + "]";
	}

}
