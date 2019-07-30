package com.sidhlogin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sidhlogin.dao.userService;
import com.sidhlogin.model.Login;
import com.sidhlogin.model.User;
@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/home")
	  public ModelAndView processUser(){
	       ModelAndView modelAndView =new ModelAndView();
	       modelAndView.setViewName("home");
	       return modelAndView;
	        }
	
	
	@RequestMapping(value = "/login")
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("login", new Login());
	    mav.setViewName("loginpage");
	    return mav;
	  }
	@RequestMapping(value = "/register")
	  public ModelAndView showRegister() {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("User", new User());
	    mav.setViewName("register");
	    return mav;
	  }

	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
		  ModelAndView mav = null;
		  	User user = userService.validateUser(login);

		    if (null != user) {
		    mav = new ModelAndView("welcome");
		    mav.addObject("firstname", user.getFirstname());
		    } else {
		    mav = new ModelAndView("home");
		    mav.addObject("message", "Username or Password is wrong!!");
		    }
	    return mav;
	  }
	}



