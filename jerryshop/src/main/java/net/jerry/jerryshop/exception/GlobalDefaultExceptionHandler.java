package net.jerry.jerryshop.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Page not constructed");
		mv.addObject("errorDescription", "Page not available");
		mv.addObject("titile", "404 Error Page");

		return mv;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Product not available");
		mv.addObject("errorDescription", "The prodcut you are looking for is not available");
		mv.addObject("titile", "product unavailalbe");

		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {

		ModelAndView mv = new ModelAndView("error");

		mv.addObject("errorTitle", "Contact your admin");

		/*
		 * only for debug
		 * 
		 */
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
//-------------------------------------------------
		ex.printStackTrace(pw);

		mv.addObject("errorDescription", sw.toString());
		mv.addObject("titile", "Error");

		return mv;
	}
}
