package com.niit.ecommerce;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommerce.dao.UserDao;
import com.niit.ecommerce.models.User;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class UserDaoTesting {
	
	static UserDao userDAO;

	@BeforeClass
	public static void execute() {
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		userDAO=(UserDao)context.getBean("userDAO");
	}
	
//	@Ignore
//	@Test
//	public void addUserTest()
//	{
//		User user=new User();
//		user.setEmail_id("vaishu@gmail.com");
//		user.setFirstname("prakhya");
//		user.setLastname("vaishali");
//		user.setContactnumber(786976);
//		user.setPassword("");
//		
//		
//		assertTrue("Probem in Adding the User",userDAO.registerCustomer(user));
//
//}
	
	//@Ignore
		@Test
		public void updateUserTest()
		{	
			User user=userDAO.getUser("vaishu@gmail.com");
			user.setFirstname("Jennie");
			assertTrue("Problem in Updating ",userDAO.updateUser(user));
		}
		//@Ignore
		@Test
		public void deleteUserTest()
		{
			User user=userDAO.getUser("");
			assertTrue("Problem in deleting ",userDAO.deleteUser(""));
		}
		@Ignore
		@Test
		public void listUsersTest()
		{
			List<User> listUsers=userDAO.listUsers();
			
			assertTrue("Problem in Listing",listUsers.size()>0);
			
			for(User user:listUsers)
			{
				System.out.print("User emailID:"+user.getEmail_id());
				System.out.print("User FirstName:"+user.getFirstname());
				System.out.println("User LastName:"+user.getLastname());
				System.out.println("User ContactNumber:"+user.getContactnumber());
				System.out.println("User Password:"+user.getPassword());
			}
		}
		
}
