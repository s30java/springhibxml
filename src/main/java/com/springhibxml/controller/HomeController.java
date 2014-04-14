package com.springhibxml.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springhibxml.model.UserModel;
import com.springhibxml.service.UserService;



@Controller
public class HomeController {

	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("user") UserModel user,  BindingResult result){
		ArrayList<String> gender = new ArrayList<String>();  
        gender.add("Male");  
        gender.add("Female");  
  
        ArrayList<String> city = new ArrayList<String>();  
        city.add("Delhi");  
        city.add("Kolkata");  
        city.add("Chennai");  
        city.add("Bangalore");  
  
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put("gender", gender);  
        model.put("city", city);  
  
        System.out.println("Register Form");  
		
		return new ModelAndView("Register","model",model);
	}
	
	@RequestMapping("/saveUser")
	public ModelAndView saveUserdata(@ModelAttribute("user") UserModel user,  BindingResult result){
		
		userService.addUser(user);
		
		System.out.println("saving user in processed .....");
	return new ModelAndView("redirect:/userList.html");	
	}
	
	  @RequestMapping("/userList")  
	    public ModelAndView getUserList() {  
	  
	        Map<String, Object> model = new HashMap<String, Object>();  
	        model.put("user", userService.getUser());  
	        return new ModelAndView("UserDetails", model);  
	  
	    } 
}
