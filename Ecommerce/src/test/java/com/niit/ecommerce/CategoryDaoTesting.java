package com.niit.ecommerce;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ecommerce.dao.CategoryDao;
import com.niit.ecommerce.models.Category;


public class CategoryDaoTesting {

	static CategoryDao categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDao)context.getBean("categoryDAO");
	}
	
	//@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryname("Curtain");
		category.setCategory_id(78);
		
		assertTrue("Probem in Adding the Category",categoryDAO.addCategory(category));
	}
	//@Ignore
	@Test
	public void updateCategoryTest()
	{	
		Category category=categoryDAO.getCategory(78);
		category.setCategoryname("Pillows");	
		assertTrue("Problem in Updating ",categoryDAO.updateCategory(category));
	}
	//@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(5);
		assertTrue("Problem in deleting ",categoryDAO.deleteCategory(0));
	}
	//@Ignore 
	@Test
	public void listCategoriesTest()
	{
		 List<Category> listCategories=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing",listCategories.size()>0);
		
		for(Category category:listCategories)
		{
			System.out.print("Category ID:"+category.getCategory_id());
			System.out.print("Category Name:"+category.getCategoryname());
			
		}
	}
	

}
