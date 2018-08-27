package net.jerry.shopbackend.dao;

import net.jerry.shopbackend.dto.Address;
import net.jerry.shopbackend.dto.Cart;
import net.jerry.shopbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);

}
