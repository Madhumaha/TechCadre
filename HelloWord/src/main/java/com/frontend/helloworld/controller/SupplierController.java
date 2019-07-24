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

import com.niit.ecommerce.dao.SupplierDao;
import com.niit.ecommerce.models.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierDAO;
	
	
	
	
	
	
	

	@RequestMapping("/admin/Supplierpage")
	public ModelAndView sup()
	{
		ModelAndView mv = new ModelAndView("Supplierpage","command",new Supplier());
		mv.addObject("supplierlist", supplierDAO.listSuppliers());
		return mv;	
	}
	@RequestMapping(value = "/admin/addsupplier", method = RequestMethod.POST)
    public String addsupplier(@ModelAttribute("SpringWeb")@Valid Supplier supplier,BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
	         return "/admin/Supplierpage";
		 }
		Supplier s=supplierDAO.getSupplier(supplier.getSupplier_id());
		if(s==null)
			supplierDAO.addSupplier(supplier);
		else
			supplierDAO.updateSupplier(supplier);
//		ModelAndView mv = new ModelAndView("Supplierpage","command",new Supplier());
//		mv.addObject("supplierlist", supplierDAO.listSuppliers());
//		 return mv;
		return "redirect:/admin/Supplierpage";
	}
		 
		 @RequestMapping("/admin/updatesupplier/{id}")
		 public ModelAndView updatesupplier(@PathVariable("id") int id)
		 {
			 Supplier s=supplierDAO.getSupplier(id);
			 ModelAndView mv=new ModelAndView("Supplierpage","command",s);
			 return mv;
		 }
		 @RequestMapping("/admin/deletesupplier/{id}")
		 public String deleteSupplier(@PathVariable("id") int id)
			{
				Supplier s=supplierDAO.getSupplier(id);
				supplierDAO.deleteSupplier(id);
				return "redirect:/admin/Supplierpage";
			}
	
	

}
