package net.jerry.jerryshop.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.jerry.jerryshop.exception.ProductNotFoundException;
import net.jerry.shopbackend.dao.CategoryDAO;
import net.jerry.shopbackend.dao.ProductDAO;
import net.jerry.shopbackend.dto.Category;
import net.jerry.shopbackend.dto.Product;

@Controller
public class PageController {
	
	private static final  Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired 
	private ProductDAO productDAO;
	
	@RequestMapping(value = {"/","/home", "/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.info("Inside PageController index method - DEBUG");	
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);		
		return mv;
	}
	@RequestMapping(value = {"/about"})
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);		
		return mv;
	}
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);		
		return mv;
	}	
	
	@RequestMapping(value = {"show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickAllProducts",true);		
		return mv;
	}
	
	@RequestMapping(value = {"show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		
		//categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing the single category
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);		
		return mv;
	}
	/*
	 * Viewing a single product
	 */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id)throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
	
		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		//
		mv.addObject("titile", product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		
		return mv;	
	}
	
	
	//similar mapping to flow id
	@RequestMapping(value = {"/register"})
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title","All Products");
		
		return mv;
	}
	
	//login
	@RequestMapping(value = {"/login"})
	public ModelAndView login(@RequestParam(name="error",required = false)String error) {
		ModelAndView mv = new ModelAndView("login");
		
		if(error != null) {
			mv.addObject("message","invalide username and password");
		}

		mv.addObject("title","Login");
		
		return mv;
	}
	
	//access denied
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");

		mv.addObject("title","403 - Access Denied");
		mv.addObject("errorTitle","Aha! Caught you.");
		mv.addObject("title","You are not authorized to view this page!");
		return mv;
	}
}
