package net.jerry.shopbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.jerry.shopbackend.dao.UserDAO;
import net.jerry.shopbackend.dto.Address;
import net.jerry.shopbackend.dto.Cart;
import net.jerry.shopbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addAddress(Address address) {
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addCart(Cart cart) {
		try{
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
