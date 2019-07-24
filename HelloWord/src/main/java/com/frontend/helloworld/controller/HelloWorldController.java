package com.frontend.helloworld.controller;
 import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.dao.CartItemDao;
import com.niit.ecommerce.dao.CategoryDao;
import com.niit.ecommerce.dao.OrderDetailsDao;
import com.niit.ecommerce.dao.ProductDao;
import com.niit.ecommerce.dao.UserDao;
import com.niit.ecommerce.models.CartItem;
import com.niit.ecommerce.models.OrderDetails;
import com.niit.ecommerce.models.Product;
import com.niit.ecommerce.models.User;

@Controller
public class HelloWorldController {
	@Autowired
	ProductDao productDAO;
	@Autowired
	CategoryDao categoryDAO;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	 OrderDetailsDao orderdetailsDao;
	@Autowired
	UserDao userDAO;
	@Autowired
	User u;
	@Autowired
	Product p;
	
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping("/hello")
	public ModelAndView showMessage()
	{
		System.out.println("in controller");
		
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", "John");
		return mv;
	}
//	
//	@RequestMapping("/")
//	public String vie()
//	{
//		return "helloworld";
//	}
//	
	
	

	
	@RequestMapping(value= {"/","/homepage"})
	public ModelAndView msg(Principal p,HttpSession session)
	{
		
		ModelAndView mv = new ModelAndView("homepage");
		if(p!=null) {
		String email=p.getName();
		u=userDAO.getUser(email);
		}
		
		
		session.setAttribute("ufname",u.getFirstname());
		mv.addObject("productlist",productDAO.listProducts());
		mv.addObject("categorylist",categoryDAO.listCategories());
		return mv;
	}
	
	
	@RequestMapping("/Navbar")
	public ModelAndView nav()
	{

		ModelAndView mv = new ModelAndView("Navbar");
		mv.addObject("categorylist",categoryDAO.listCategories());
		return mv;
	}
	
	
	
	
	@RequestMapping("/signin")
	public ModelAndView in()
	{

		ModelAndView mv = new ModelAndView("signin");
		mv.addObject("categorylist",categoryDAO.listCategories());
		return mv;
	}
		

	
	@RequestMapping("/signup")
	public ModelAndView up()
	{
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("categorylist",categoryDAO.listCategories());
		return mv;
		
	}
	
	@RequestMapping("/viewproduct/{product_id}")
	public ModelAndView view(@PathVariable("product_id") int id)
	{
		
		
		Product p=productDAO.getProduct(id);
		ModelAndView mv = new ModelAndView("viewproduct","product",p);
		mv.addObject("categorylist",categoryDAO.listCategories());
		return mv;
		
	}
	
//	@RequestMapping("/catdisplay/${c.category_id}")
//	public ModelAndView catpro()
//	{
//		
//	}
	
	
	@RequestMapping("/orderdisplay")
	public String display(@AuthenticationPrincipal Principal principal,Model model){
		String email=principal.getName();
		User user=userDAO.getUser(email);
		System.out.println(email);
	  List<OrderDetails> OrderDetails=orderdetailsDao.listOrders(email);
	  model.addAttribute("odlist",OrderDetails);
			return "orderdetails"; 
		
	}
	
	@RequestMapping("/carousel")
	public ModelAndView car()
	{
		ModelAndView mv = new ModelAndView("carousel");
		return mv;
		
	}
	
	@RequestMapping("/Carddetails")
	public ModelAndView card()
	{
		ModelAndView mv = new ModelAndView("Carddetails");
		mv.addObject("categorylist",categoryDAO.listCategories());
		return mv;
	}
	
	@RequestMapping("/admin/adminpage")
	public ModelAndView url()
	{
		ModelAndView mv=new ModelAndView("url");
		mv.addObject("categorylist",categoryDAO.listCategories());
		return mv;
	}
	
//	@RequestMapping("/orderdetails")
//	public String createOrderDetails(@ModelAttribute int orderid, Model model,
//			@AuthenticationPrincipal Principal principal,HttpSession session){
//		
//		
//		
////		Customer customer=user.getCustomer();
////		customer.setShippingAddress(shippingAddress);
////		
////		user.setCustomer(customer);
////		customer.setUser(user);
//		
//		String email=principal.getName();
//	User user=cartItemDao.getUser(email);
//		OrderDetails order=new OrderDetails();
//		order.setPurchaseDate(new Date());
//		order.setUser(user);
//		
//		List<OrderDetails> OrderDetails=.getCartItem(email);
//		double grandTotal=0.0;
//		for(CartItem cartItem:cartItems){
//			grandTotal=cartItem.getTotalPrice()+grandTotal;
//		}
//		(grandTotal);
//		//insert into customerorder values (....)
//		//update shippingaddress set ..... where shippingid=?
//		cartItemDao.createOrderDetails(OrderDetails);
//		model.addAttribute("cartItems",cartItems);
//		//delete all cartitem's from cartitem table for this login id
//		//update the product quantity 
//		
////		for(CartItem cartItem:cartItems){
////			Product product=cartItem.getProduct();
////			product.setQuantity(product.getQuantity() - cartItem.getQuantity());
////			productDao.saveOrUpdate(product);
////			cartItemDao.removeCartItem(cartItem.getCartItemId());
////		}
//		session.setAttribute("cartSize", 0);
//		model.addAttribute("OrderDetails",orderdetails);
//		return "orderdetails";
//	}

	
}


