package com.frontend.helloworld.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ecommerce.dao.CartItemDao;
import com.niit.ecommerce.dao.OrderDetailsDao;
import com.niit.ecommerce.dao.ProductDao;
import com.niit.ecommerce.dao.UserDao;
import com.niit.ecommerce.models.CartItem;
import com.niit.ecommerce.models.OrderDetails;
import com.niit.ecommerce.models.Product;
import com.niit.ecommerce.models.User;

@Controller
public class CartItemController {
	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	 UserDao userDAO;
	@Autowired
	 OrderDetailsDao orderdetailsDao;
	@Autowired
	Product p;
		
	@RequestMapping(value="/cart/addtocart/{product_id}")
	public String addToCart(@PathVariable int product_id,
			@RequestParam int requestedQuantity,@AuthenticationPrincipal Principal principal){//get two values from jsp page
		//1st value - product id
		//2nd value - requested quantity
		//to get user, use Principal Object
		//user,product,totalPrice,requested quantity
		String email="";
		if(principal!=null)
		email=principal.getName();
		
		
		Product product=productDao.getProduct(product_id);
		User user=cartItemDao.getUser(email);
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(requestedQuantity);
		cartItem.setProduct(product);
		cartItem.setTotalPrice(product.getPrice()*requestedQuantity);
		cartItem.setUser(user);
		int flag=0;
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		if(cartItems.size()==0 && requestedQuantity<=product.getQuantity())
		cartItemDao.addToCart(cartItem);
		else
		{
		for(CartItem ct:cartItems)
		{
			p=ct.getProduct();
			if(p.getProduct_id()==product_id)
			{
				flag=1;
				ct.setQuantity(ct.getQuantity()+requestedQuantity);
				ct.setTotalPrice(ct.getProduct().getPrice()*ct.getQuantity());
				System.out.println(ct.getQuantity());
				System.out.println(ct.getTotalPrice());
				
				if(ct.getQuantity()<=product.getQuantity())
				{
			cartItemDao.updateCart(ct);
				}
			}
		}
			if(flag==0 && requestedQuantity<=product.getQuantity())
			cartItemDao.addToCart(cartItem);
		
		}
		
		
		return "redirect:/cart/getcartitems";
	}
		
		
		
		
	
	
	
	
	@RequestMapping("/cart/getcartitems")
	public String getCartItems(@AuthenticationPrincipal Principal principal,Model model		){
		List<CartItem> cartItems=null;
		if(principal!=null)
		cartItems=cartItemDao.getCartItems(principal.getName());
		model.addAttribute("cartItems",cartItems);
		return "cart";
	}
	@RequestMapping("/cart/updatecartitem")
	public String updateCartItem(@RequestParam int cartItemId,@RequestParam int requestedQuantity){
		System.out.println(cartItemId + " " + requestedQuantity);
		cartItemDao.updateCartItem(cartItemId,requestedQuantity);
		return "redirect:/cart/getcartitems";
	}

	@RequestMapping(value="/cart/deletecartitem/{cartItemId}")
	public String deleteCartItem(@PathVariable int cartItemId){
	    cartItemDao.deleteCartItem(cartItemId);
		return "redirect:/cart/getcartitems";
	}
	
	
	@RequestMapping(value="/cart/createorder")
	public String createCustomerOrder(@AuthenticationPrincipal Principal principal,HttpSession session){
		//set updated shippingaddress in customer object 
		
		String email=principal.getName();
		User user=userDAO.getUser(email);
		
		
		OrderDetails order=new OrderDetails();
		order.setPurchaseDate(new Date());
		order.setUser(user);
		
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		double grandTotal=0.0;
		for(CartItem cartItem:cartItems){
			grandTotal=cartItem.getTotalPrice()+grandTotal;
		}
		order.setGrandTotal(grandTotal);
		orderdetailsDao.addOrder(order);
		for(CartItem cartItem:cartItems){
			p=cartItem.getProduct();
			p.setQuantity(p.getQuantity()-cartItem.getQuantity());
			productDao.updateProduct(p);
			cartItemDao.deleteCartItem(cartItem.getCartItemId());
		}
		
		return "redirect:/orderdisplay";
	}
	

	}

