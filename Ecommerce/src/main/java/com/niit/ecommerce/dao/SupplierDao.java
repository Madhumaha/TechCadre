package com.niit.ecommerce.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ecommerce.models.Supplier;

@Repository("supplierDAO")
public interface SupplierDao {
	boolean addSupplier(Supplier supplier);
	Supplier getSupplier(int id);
	boolean updateSupplier(Supplier s);
	boolean deleteSupplier(int id);
	List<Supplier> listSuppliers();

}
