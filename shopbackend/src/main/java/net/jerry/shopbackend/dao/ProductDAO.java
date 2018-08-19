package net.jerry.shopbackend.dao;


import java.util.List;

import net.jerry.shopbackend.dto.Product;

public interface ProductDAO  {
	
	Product get(int productId);
	
	List<Product> list();
	
	boolean add(Product product);
	boolean delete(Product product);
	boolean update(Product product);
	
	//business 
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);	
}
