package com.niit.ecommerce;



import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommerce.dao.ProductDao;
import com.niit.ecommerce.models.Product;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class ProductDAOTesting {
	
	static ProductDao productDAO;

	@BeforeClass
	public static void execute() {
AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDao)context.getBean("productDAO");
	}
	
	//@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProduct_id(23);
		product.setProductname("Window");
		product.setDescription("black");
		product.setQuantity(6);
		
		assertTrue("Probem in Adding the Category",productDAO.addProduct(product));
	}
	
	//@Ignore
	@Test
	public void updateProductTest()
	{	
		Product product=productDAO.getProduct(23);
		product.setProductname("crafts");	
		assertTrue("Problem in Updating ",productDAO.updateProduct(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(5);
		assertTrue("Problem in deleting ",productDAO.deleteProduct(5));
	}
	@Ignore
	@Test
	public void listProductsTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		
		assertTrue("Problem in Listing",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.println("Product ID:"+product.getProduct_id());
			System.out.println("Product Name:"+product.getProductname());
			System.out.println("Product Desc:"+product.getDescription());
			System.out.println("Product Price:"+product.getPrice());
			System.out.println("Product Quantity:"+product.getQuantity());
		}
	}
	
}




//	
//
//
