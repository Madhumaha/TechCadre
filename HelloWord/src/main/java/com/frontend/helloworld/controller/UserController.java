package com.frontend.helloworld.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.UserDao;
import com.niit.ecommerce.models.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDAO;
	
	
	@RequestMapping("/Userpage")
	public ModelAndView use()
	{
		ModelAndView mv = new ModelAndView("Userpage","command",new User());
		try
		{
		mv.addObject("userlist", userDAO.listUsers());
		}
		catch(Exception e)
		{
			
		}
		return mv;
		}
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ModelAndView adduser(@ModelAttribute("command")@Valid User user,BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			ModelAndView mv=new ModelAndView("Userpage","command",new User());
	         return mv;
		 }
		userDAO.registerCustomer(user);
		ModelAndView mv = new ModelAndView("signin");
		mv.addObject("userlist", userDAO.listUsers());
		return mv;
	}

}
