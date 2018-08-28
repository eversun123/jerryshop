package net.jerry.shopbackend.daoimpl;

import java.util.List;

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
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Address getBillingAddress(User user) {
		String selectQuery ="FROM Address WHERE user = :user AND billing = :billing";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Address.class)
					.setParameter("user", user)
					.setParameter("billing", true)
					.getSingleResult();
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public List<Address> listShippingAddresses(User user) {
		String selectQuery ="FROM Address WHERE user = :user AND shipping = :shipping";
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(selectQuery,Address.class)
					.setParameter("user", user)
					.setParameter("shipping", true)
					.getResultList();
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
