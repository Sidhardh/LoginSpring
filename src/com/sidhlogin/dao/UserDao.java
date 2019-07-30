package com.sidhlogin.dao;

import com.sidhlogin.model.Login;
import com.sidhlogin.model.User;

public interface UserDao {
 User validateUser(Login login);
 public int insertUser(User u);
	}

