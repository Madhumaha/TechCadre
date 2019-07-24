package com.niit.ecommerce;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommerce.dao.SupplierDao;
import com.niit.ecommerce.models.Supplier;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class SupplierDaoTesting {
	static SupplierDao supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO=(SupplierDao)context.getBean("supplierDAO");
	}
	
	@Ignore
	@Test
	public void addSupplierTest()
	{
	    Supplier supplier=new Supplier();
		supplier.setSuppliername("Harshi");
		supplier.setSupplier_id(10);
		
		assertTrue("Probem in Adding ",supplierDAO.addSupplier(supplier));
	}

	//@Ignore
		@Test
		public void updateSpplierTest()
		{	
			Supplier supplier=supplierDAO.getSupplier(10);
			supplier.setSuppliername("Hanbin");	
			
			assertTrue("Problem in Updating ",supplierDAO.updateSupplier(supplier));
		}
		//@Ignore
		@Test
		public void deleteSupplierTest()
		{
			Supplier supplier=supplierDAO.getSupplier(5);
			assertTrue("Problem in deleting ",supplierDAO.deleteSupplier(5));
		}
		@Ignore
		@Test
		public void listSuppliersTest()
		{
			List<Supplier> listSuppliers=supplierDAO.listSuppliers();
			
			assertTrue("Problem in Listing",listSuppliers.size()>0);
			
			for(Supplier supplier:listSuppliers)
			{
				System.out.print("Supplier ID:"+supplier.getSupplier_id());
				System.out.print("Supplier Name:"+supplier.getSuppliername());
				
			}
		}
		
	
	
	
	

}
