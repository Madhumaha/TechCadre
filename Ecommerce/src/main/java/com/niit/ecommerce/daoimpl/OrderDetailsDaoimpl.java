package com.niit.ecommerce.daoimpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommerce.dao.OrderDetailsDao;
import com.niit.ecommerce.models.OrderDetails;
@Transactional
@Repository("orderdetailsDAO")
public class OrderDetailsDaoimpl implements OrderDetailsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
		public OrderDetailsDaoimpl(){
			System.out.println("OrderDetailsDaoImpl bean is created..");
		}
		public boolean addOrder(OrderDetails order) {
	       Session session= sessionFactory.getCurrentSession();
	       session.save(order);//Generate insert query..
	       return true;
		}
		public OrderDetails getOrder(int id) {
			Session session=sessionFactory.getCurrentSession();
			OrderDetails order=(OrderDetails)session.get(OrderDetails.class, id);
			//SQL query select * from product where id=?
			return order;
		}
		@Override
		public List<OrderDetails> listOrders(String email) {
			
			    String s1="from OrderDetails where  user.email_id='"+email+"'";
				Query o=sessionFactory.getCurrentSession().createQuery(s1);
				List<OrderDetails> list=o.list();
				return list;
			
			
		}
		@Override
		public List<OrderDetails> listProductswiseOrderdetails(int product_id) {
			// TODO Auto-generated method stub
			return null;
		}
	

}
