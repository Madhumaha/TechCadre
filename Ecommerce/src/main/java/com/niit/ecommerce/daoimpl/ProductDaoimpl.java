package com.niit.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommerce.dao.ProductDao;
import com.niit.ecommerce.models.Product;
  
@Transactional
@Repository("productDAO")
public class ProductDaoimpl implements ProductDao
{
	@Autowired
	private SessionFactory sessionFactory;
		public ProductDaoimpl(){
			System.out.println("ProductDaoImpl bean is created..");
		}
		public boolean addProduct(Product product) {
	       Session session= sessionFactory.getCurrentSession();
	       session.save(product);//Generate insert query..
	       return true;
		}
		public Product getProduct(int id) {
			Session session=sessionFactory.getCurrentSession();
			Product product=(Product)session.get(Product.class, id);
			//SQL query select * from product where id=?
			return product;
		}
		@Override
		public boolean updateProduct(Product pro) {
			
			Session s=sessionFactory.getCurrentSession();
			try {
			s.update(pro);
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		@Override
		public boolean deleteProduct(int id) {
			Product p=getProduct(id);
			Session s=sessionFactory.getCurrentSession();
			try
			{
			s.delete(p);
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		@Override
		public List<Product> listProducts() {
			
			String s1="from Product";
			Query q=sessionFactory.getCurrentSession().createQuery(s1);
			List<Product> plist=q.list();
			return plist;
		}
		@Override
		public List<Product> listCategoryWiseProducts(int category_id) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Product> listSupplierWiseProducts(int supplier_id) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Product> getProductbycat(int catid) {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Product where category_id="+catid);
			List<Product> catProductlist=query.list();
			return catProductlist;
		}
		

	}


