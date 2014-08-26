package com.training.crud.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
//import java.util.Scanner;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.crud.database.DatabaseClass;
import com.training.crud.model.UserBeanManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Resource(name="customerDAO")
	DatabaseClass customerDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/page1",method=RequestMethod.POST)
	public ModelAndView page1(@RequestParam(value="emailid")String useremail,@RequestParam(value="password")String userpassword, Model model){
		ModelAndView modelAndView = new ModelAndView("page1");
		
		String abc=useremail.split("@")[0];
		UserBeanManager user=new UserBeanManager(useremail,userpassword);
		
		
		      
        UserBeanManager customer = new UserBeanManager(useremail,userpassword);
        customerDAO.insert(customer);
		
		modelAndView.addObject("message",abc);
		
		
		
		return modelAndView;
	}
	@RequestMapping(value="page2",method=RequestMethod.POST)
	public ModelAndView page2(){
		String a=customerDAO.searchByEmailId();
		ModelAndView mod = new ModelAndView("page2");
		mod.addObject("tablecontent", a);
		return mod;
		
	}
	
}
