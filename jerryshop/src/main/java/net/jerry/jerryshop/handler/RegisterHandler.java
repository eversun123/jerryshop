package net.jerry.jerryshop.handler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import net.jerry.jerryshop.model.RegisterModel;
import net.jerry.shopbackend.dao.UserDAO;
import net.jerry.shopbackend.dto.Address;
import net.jerry.shopbackend.dto.Cart;
import net.jerry.shopbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel,User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel,Address billing) {
		registerModel.setBilling(billing);;
	}
	
	public String validateUser(User user , MessageContext error) {
		
		String transitionValue = "success";
		
		if(user.getPassword().equals(user.getConfirmPassword())==false){
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("password not matched!")
					.build());
			transitionValue = "failure";
		}
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Email taken !")
					.build());
			transitionValue = "failure";
		}
		
		return transitionValue;
	}
	
	public String saveAll(RegisterModel model) {
		
		String transitionValue = "success";
		
		// fetch the user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			
			Cart cart= new Cart();
			
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//save user
		
		userDAO.addUser(user);
		
		// get the address
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}

}
