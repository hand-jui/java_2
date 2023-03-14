package com.jui.myblog.dao;

import com.jui.myblog.dto.UserDTO;

public interface IUserDAO {

	int saveUser(UserDTO user); // insert

	UserDTO select(String username);

	UserDTO selectUserByusernameANDpassword(String username, String password);

	int deleteUserByusernameANDpassword(String username, String password); // delete

}
