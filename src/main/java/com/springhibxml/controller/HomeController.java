package com.springhibxml.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springhibxml.model.UserModel;
import com.springhibxml.service.UserService;



@Controller
public class HomeController {

	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("user") UserModel user,  BindingResult result){
		Map<String, Object> model = loadData();  
		
        System.out.println("Register Form");  
		
		return new ModelAndView("Register","model",model);
	}

	private Map<String, Object> loadData() {
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
		return model;
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
	  
	  @RequestMapping(value="/user/edit/{id}", method=RequestMethod.GET)
	  public ModelAndView editUser(@PathVariable Integer id){
		  ModelAndView modelView=new ModelAndView("Edit-UserForm");
		  UserModel user=userService.getUser(id);
		
		  modelView.addObject("user", user);
		  return modelView;
	  }
	  
	  //call this method when form is been submitted
	  @RequestMapping(value="/user/edit/{id}", method=RequestMethod.POST)
	  public ModelAndView saveEditedUser(@ModelAttribute UserModel user,@PathVariable Integer id){
		  ModelAndView modelAndView=new ModelAndView("redirect:/userList.html");
		  userService.updateUser(user);
			String message = "User was successfully edited.";
			modelAndView.addObject("message", message);
		  return modelAndView;
	  }
	  
	  @RequestMapping(value="/user/delete/{id}", method=RequestMethod.GET)
	  public ModelAndView deleteUser(@PathVariable Integer id){
		  ModelAndView modelAndView=new ModelAndView("redirect:/userList.html");
		  userService.deleteUser(id);
			String message = "User was successfully deleted.";
			modelAndView.addObject("message", message);
		  return modelAndView;
	  }
}
