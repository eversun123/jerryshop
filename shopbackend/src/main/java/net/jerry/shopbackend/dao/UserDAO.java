package net.jerry.shopbackend.dao;

import net.jerry.shopbackend.dto.Address;
import net.jerry.shopbackend.dto.Cart;
import net.jerry.shopbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	
	boolean updateCart(Cart cart);

}
