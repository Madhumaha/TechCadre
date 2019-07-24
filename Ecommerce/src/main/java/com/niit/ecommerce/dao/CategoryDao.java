package com.niit.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecommerce.models.Category;
import com.niit.ecommerce.models.Product;

@Repository("categoryDAO")
public interface CategoryDao {
	boolean addCategory(Category category);
    Category getCategory(int id);
    boolean updateCategory(Category c);
    boolean deleteCategory(int id);
    List<Category> listCategories();


}
