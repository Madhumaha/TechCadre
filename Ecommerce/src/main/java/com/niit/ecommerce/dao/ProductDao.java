package com.niit.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecommerce.models.Product;

@Repository("productDAO")
public interface ProductDao {
	boolean addProduct(Product product);
	Product getProduct(int id);
boolean updateProduct(Product p);
boolean deleteProduct(int id);
List<Product> listProducts();
public List<Product> listCategoryWiseProducts(int category_id);
public List<Product> listSupplierWiseProducts(int supplier_id);
List<Product> getProductbycat(int catid);
}
