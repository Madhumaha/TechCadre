package com.frontend.helloworld.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CategoryDao;
import com.niit.ecommerce.models.Category;

@Controller
public class CategoryController {
	@Autowired
	CategoryDao categoryDAO;
	
	@RequestMapping("/admin/Categorypage")
	public ModelAndView cat()
	{
		ModelAndView mv = new ModelAndView("Categorypage","command",new Category());
		mv.addObject("categorylist", categoryDAO.listCategories());
		return mv;
		}
	@RequestMapping(value = "/admin/addcategory", method = RequestMethod.POST)
    public String addcategroy(@ModelAttribute("SpringWeb")@Valid Category category,BindingResult bindingResult, ModelMap model) {
		 if (bindingResult.hasErrors()) {
	         return "/admin/Categorypage";
		 }
		Category c=categoryDAO.getCategory(category.getCategory_id());
		if(c==null)
			categoryDAO.addCategory(category);
		else 
			categoryDAO.updateCategory(category);
//		ModelAndView mv = new ModelAndView("Categorypage","command",new Category());
//		mv.addObject("categorylist", categoryDAO.listCategories());
//		 return mv;
		return "redirect:/admin/Categorypage";
	}
	@RequestMapping("/admin/updatecategory/{id}")
	 public ModelAndView updatecategory(@PathVariable("id") int id)
	 {
		 Category c=categoryDAO.getCategory(id);
		 ModelAndView mv=new ModelAndView("Categorypage","command",c);
		 return mv;
	 }
	 @RequestMapping("/admin/deletecategory/{id}")
	 public String deleteCategory(@PathVariable("id") int id)
		{
			Category c=categoryDAO.getCategory(id);
			categoryDAO.deleteCategory(id);
			return "redirect:/admin/Categorypage";
		}
	
}
