package net.jerry.shopbackend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.jerry.shopbackend.dao.UserDAO;
import net.jerry.shopbackend.dto.Address;
import net.jerry.shopbackend.dto.Cart;
import net.jerry.shopbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.jerry.shopbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
/*	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("123456");
		user.setRole("USER");
		user.setPasswords("123456");
		
		//add the user
		assertEquals("failed to add the user",true,userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("setAddressLineOne");
		address.setAddressLineTwo("setAddressLineTwo");
		address.setCity("Shenzhen");
		address.setState("GD");
		address.setCountry("CN");
		address.setPostalCode("510000");
		address.setBilling(true);
		
		// link user with address
		address.setUserId(user.getId());
		
		// add the address
		assertEquals("failed to add the address",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			//create a cart 
			cart = new Cart();
			
			cart.setUser(user);
			assertEquals("failed to add the cart",true,userDAO.addCart(cart));
			// add shipping address for this user
			address = new Address();
			address.setAddressLineOne("setAddressLineOne");
			address.setAddressLineTwo("setAddressLineTwo");
			address.setCity("Shenzhen");
			address.setState("GD");
			address.setCountry("CN");
			address.setPostalCode("510000");
			address.setBilling(true);
			
			address.setShipping(true);
			
			address.setUserId(user.getId());
			
			assertEquals("failed to add the address",true,userDAO.addAddress(address));			
					
			
		}
	}*/
/*	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("123456");
		user.setRole("USER");
		user.setPasswords("123456");
		
		if(user.getRole().equals("USER")) {
			//create a cart 
			cart = new Cart();
			
			cart.setUser(user);
			
			//attach user with cart
			user.setCart(cart);
		}
		
		//add the user
		assertEquals("failed to add the user",true,userDAO.addUser(user));	
	}*/
	
/*	@Test
	public void testUpdateCart() {
		user = userDAO.getByEmail("hr@gmail.com");
		
		cart = user.getCart();
		
		cart.setGrandTotal(5555);
		
		cart.setCartLines(2);
		
		assertEquals("failed to update the cart!",true,userDAO.updateCart(cart));	
	}*/
	
/*	@Test
	public void testAddAddress()
	{
		// add and user
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("123456");
		user.setRole("USER");
		user.setPasswords("123456");
		
		//add the user
		assertEquals("failed to add the user",true,userDAO.addUser(user));
	
		// add the address
		
		address = new Address();
		address.setAddressLineOne("setAddressLineOne");
		address.setAddressLineTwo("setAddressLineTwo");
		address.setCity("Shenzhen");
		address.setState("GD");
		address.setCountry("CN");
		address.setPostalCode("510000");
		address.setBilling(true);	
		
		// attach the user to the address
		address.setUser(user);
		assertEquals("failed to add the billing address!",true,userDAO.addAddress(address));		
		
		//add the shipping address
		address = new Address();
		address.setAddressLineOne("setAddressLineOne");
		address.setAddressLineTwo("setAddressLineTwo");
		address.setCity("Shenzhen");
		address.setState("GD");
		address.setCountry("CN");
		address.setPostalCode("510000");
	
		address.setShipping(true);
		address.setUser(user);
		assertEquals("failed to add the shipping address!",true,userDAO.addAddress(address));	
	}*/
/*	@Test
	public void testAddAddress() {
		
		user = userDAO.getByEmail("hr@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("setAddressLineOne");
		address.setAddressLineTwo("setAddressLineTwo");
		address.setCity("sdfs");
		address.setState("sdfs");
		address.setCountry("sfsd");
		address.setPostalCode("510000");
	
		address.setShipping(true);
		address.setUser(user);
		assertEquals("failed to add the shipping address!",true,userDAO.addAddress(address));			
		
	}*/
	
	@Test
	public void testGetAddresses() {
		
		user = userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("failed to fetch the list of address and size not match!",2,userDAO.listShippingAddresses(user).size());		
		
		assertEquals("failed to fetch the billing address and size not match!","Shenzhen",userDAO.getBillingAddress(user).getCity());	
		
	}
	
}
