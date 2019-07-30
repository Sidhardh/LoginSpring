package com.sidhlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sidhlogin.dao.userService;
import com.sidhlogin.model.User;

@Controller
public class RegisterControll {
	@RequestMapping(value = "/registerProcess")
	  public ModelAndView showLogin(@ModelAttribute("user") User user) {
		 ModelAndView mav = null;
		System.out.println(user.getAddress());
		System.out.println(user.getFirstname());
		System.out.println(user);
		 int sts=userService.insertUser(user);
		 System.out.println(sts);
		if(sts!=0){	
			mav = new ModelAndView("home");
		 mav.addObject("message", "Success");
		 
		 }
		else
		{
			 mav = new ModelAndView("home");
			    mav.addObject("message", "Not Inserted!!");
		}
		return mav;
		
	  }
}

