package net.jerry.shopbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jerry.shopbackend.dao.CategoryDAO;
import net.jerry.shopbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	//@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<Category>();

	static {
		Category category = new Category();

		// add first category
		category.setId(1);
		category.setName("电视");
		category.setDescription("This is some description for Television");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// second category
		category = new Category();
		category.setId(2);
		category.setName("手机");
		category.setDescription("This is some description for Mobile");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		// second category
		category = new Category();
		category.setId(3);
		category.setName("电脑");
		category.setDescription("This is some description for Laptop");
		category.setImageURL("CAT_3.png");

		categories.add(category);
	}

	public List<Category> list() {

		return categories;
	}

	public Category get(int id) {

		for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}

		return null;
	}


	@Transactional
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
