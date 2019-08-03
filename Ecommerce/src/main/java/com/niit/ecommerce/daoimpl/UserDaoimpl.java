package com.niit.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommerce.dao.UserDao;
import com.niit.ecommerce.models.Authorities;
import com.niit.ecommerce.models.User;
@Repository("userDAO")
@Transactional
public class UserDaoimpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;
		public UserDaoimpl(){
			System.out.println("UserDaoImpl bean is created..");
		}
		public void registerCustomer(User u) {
			System.out.println("calling register function");
			Session session=sessionFactory.getCurrentSession();
			
			Authorities authorities=u.getAuthorities();
					
			
			session.save(u);
			authorities.setUser(u);
		}

		
		public User getUser(String email) {
			Session session=sessionFactory.getCurrentSession();
			try
			{
			User user=(User)session.get(User.class, email);
			//SQL query select * from user where id=?
			return user;
			}
			catch(Exception e)
			{
				return null;
			}
		}
		@Override
		public boolean updateUser(User use) {
			
			Session s=sessionFactory.getCurrentSession();
			try {
			s.update(use);
			return true;
			}
			catch(Exception e1)
			{
				return false;
			}
			
			
		}
		@Override
		public boolean deleteUser(String em) {
			User u=getUser(em);
			Session s=sessionFactory.getCurrentSession();
			try
			{
				s.delete(u);
				return true;
			}
			catch(Exception e) {
				return false;
			}
			
		}
		
		@Override
		public List<User> listUsers() {
			String s4="from User";
			Query e=sessionFactory.getCurrentSession().createQuery(s4);
			List<User> ulist=e.list();
			return ulist;
				
		}
		

}
