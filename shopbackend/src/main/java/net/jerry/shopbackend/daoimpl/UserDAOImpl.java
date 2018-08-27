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
	
	public boolean addUer(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

}
