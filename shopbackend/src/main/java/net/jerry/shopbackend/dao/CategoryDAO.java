package net.jerry.shopbackend.dao;


import java.util.List;

import net.jerry.shopbackend.dto.Category;

public interface CategoryDAO {
	
//	boolean add(Category category);
	
	List<Category> list();
	Category get(int id);
	
	
}
