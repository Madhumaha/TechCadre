package com.niit.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecommerce.models.CartItem;
import com.niit.ecommerce.models.User;
@Repository("cartItemDao")
public interface CartItemDao {
	void addToCart(CartItem cartItem);
	User getUser(String email);
	List<CartItem> getCartItems(String email);
	void deleteCartItem(int cartItemId);
	void updateCartItem(int cartItemId, int requestedQuantity);
	void updateCart(CartItem c);
	//CustomerOrder createCustomerOrder(CustomerOrder customerOrder);
}
