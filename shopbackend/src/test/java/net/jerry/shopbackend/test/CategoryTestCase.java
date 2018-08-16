package net.jerry.shopbackend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.jerry.shopbackend.dao.CategoryDAO;
import net.jerry.shopbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.jerry.shopbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	
	}
	
//	@Test
//	public  void testAddCategory() {
//		
//		category = new Category();
//		
//		category.setName("电视");
//		category.setDescription("This is some description for Television");
//		category.setImageURL("CAT_1.png");
//		
//		assertEquals("Successfully added a category inside the table!",true, categoryDAO.add(category));
//		
//	}
	
/*	@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(3);
		
		assertEquals("Successfully got a category inside the table!","Mobile", category.getName());
		
	}*/
	
/*	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("update");
		
		assertEquals("Successfully update a category inside the table!",true, categoryDAO.update(category));
		
	}
	*/
/*	@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(3);
		
		assertEquals("Successfully delete a category inside the table!",true, categoryDAO.delete(category));
		
	}*/
	
	@Test
	public void testListCategory() {
		
		assertEquals("Successfully got category list inside the table!",2, categoryDAO.list().size());
		
	}
}
