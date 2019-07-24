package com.niit.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecommerce.models.User;

@Repository("userDAO")
public interface UserDao {
	
	public void registerCustomer(User u) ;
	User getUser(String email);
	boolean updateUser(User u);
	boolean deleteUser(String email);
	List<User> listUsers();


}
