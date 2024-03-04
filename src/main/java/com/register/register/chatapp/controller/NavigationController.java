package com.register.register.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.register.register.chatapp.model.LoginDto;
import com.register.register.chatapp.model.User;
import com.register.register.chatapp.service.UserService;

import jakarta.validation.Valid;
@Controller
@RequestMapping("/nav")
public class NavigationController {
	Model model;
	User user;
	@Autowired
	private UserService userService;
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("loginDto", new LoginDto());
		return "login";
	}
	@GetMapping("/register")
	public String getRegistration(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@GetMapping("/index")
	public String getIndex() {
		return "index";
	}
//	 @PostMapping("/doregister")
//	public String register(@RequestParam("email")String email,@RequestParam("password") String password,
//			@RequestParam("fullName") String fullName,@RequestParam("phoneNumber")String phoneNumber) {
//		 System.out.println("email:"+email+"passsword:"+password+"FullName"+fullName+"PhoneNumber"+phoneNumber);
//		return "/login";
//	}
	@PostMapping("/doregister")
	public String register(@Valid @ModelAttribute User user,BindingResult bindingResult,Model model ) {
		    if(bindingResult.hasErrors()) {
		    	return "/register";
		    }
		    	userService.addUser(user);
				System.out.println(user.toString());
				
				model.addAttribute("loginDto", new LoginDto());
				return "login";
			
		
	
	}
	@PostMapping("/dologin")
	public String doLogin(@Valid @ModelAttribute LoginDto loginDto ,BindingResult bindingResult) {
		String password=loginDto.getPassword();
		System.out.println(loginDto.getEmail()+loginDto.getPassword());
		if(bindingResult.hasErrors()) {
			return "login";
		}try {
			this.user=userService.getUser(loginDto.getEmail());
		}catch(Exception ex) {
			bindingResult.addError(new FieldError("LoginDto", "email", "This email is not registered please check your email"));
			ex.printStackTrace();
			return "login";
		}
		
		System.out.println("checking user value ______________________________");
		if(user == null) {
			return "login";
		}
		System.out.println(user.toString());
		if(password.equals(user.getPassword())) {
			return "/index";
		}else {
			bindingResult.addError(new FieldError("LoginDto", "password", "the Entered password is not correct "));
			return "login";
		}
//		System.out.println(user.toString());
//		System.out.println(email+password);
//		return "index";
	}
	
}
