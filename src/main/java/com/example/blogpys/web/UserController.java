package com.example.blogpys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blogpys.domain.user.User;
import com.example.blogpys.domain.user.UserRepository;
import com.example.blogpys.web.dto.SignupReqDto;

@Controller
public class UserController {
	
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/signupForm")
	public String signupForm() {
		return "user/signupForm";
	}
	
	@PostMapping("/signup")
	public String signup(SignupReqDto signupReqDto) {
		User user = new User();
		user.setUsername(signupReqDto.getUsername());
		user.setPassword(signupReqDto.getPassword());
		user.setEmail(signupReqDto.getEmail());
		
		userRepository.save(user);
		return "redirect:/home";
	}
}
