package com.sidhlogin.dao;

import com.sidhlogin.model.Login;
import com.sidhlogin.model.User;

public class userService {
	public static User validateUser(Login lg)
	{
		User usr=new User();
		UserDaoImpl user=new UserDaoImpl();
		usr=user.validateUser(lg);
		return usr;
	}
	public static int insertUser(User u)
	{
		UserDaoImpl user=new UserDaoImpl();
		System.out.println(u + "Sss");
		return user.insertUser(u);
		
	}
}
