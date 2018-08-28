package net.jerry.shopbackend.dao;

import java.util.List;

import net.jerry.shopbackend.dto.Address;
import net.jerry.shopbackend.dto.Cart;
import net.jerry.shopbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddresses(User user);
	
	
	boolean updateCart(Cart cart);

}
