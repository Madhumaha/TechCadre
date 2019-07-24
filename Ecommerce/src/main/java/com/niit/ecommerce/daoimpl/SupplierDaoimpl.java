package com.niit.ecommerce.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ecommerce.dao.SupplierDao;
import com.niit.ecommerce.models.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDaoimpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;
		public SupplierDaoimpl(){
			System.out.println("SupplierDaoImpl bean is created..");
		}
		public boolean addSupplier(Supplier supplier) {
	       Session session= sessionFactory.getCurrentSession();
	       session.save(supplier);//Generate insert query..
	       return true;
		}
		public Supplier getSupplier(int id) {
			Session session=sessionFactory.getCurrentSession();
			Supplier supplier=(Supplier)session.get(Supplier.class, id);
			//SQL query select * from product where id=?
			return supplier;
		}
		@Override
		public boolean updateSupplier(Supplier sup) {
			
			Session s=sessionFactory.getCurrentSession();
			try
			{
				s.update(sup);
				return true;
			}
			catch (Exception e)
			{
			return false;
			}
			
				
		}
		@Override
		public boolean deleteSupplier(int id) {
			Supplier su=getSupplier(id);
			Session s=sessionFactory.getCurrentSession();
			try 
			{
			s.delete(su);
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
			
		}
		@Override
		public List<Supplier> listSuppliers() {
			String s3="from Supplier";
			Query y=sessionFactory.getCurrentSession().createQuery(s3);
			List<Supplier> slist=y.list();
			return slist;
			
			
		}
		
}
