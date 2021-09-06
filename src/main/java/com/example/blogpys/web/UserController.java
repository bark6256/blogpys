package com.example.blogpys.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.blogpys.domain.user.User;
import com.example.blogpys.domain.user.UserRepository;
import com.example.blogpys.web.dto.LoginReqDto;
import com.example.blogpys.web.dto.SignupReqDto;

@Controller
public class UserController {
	
	private UserRepository userRepository;
	private HttpSession session;
	
	public UserController(UserRepository userRepository, HttpSession session) {
		this.userRepository = userRepository;
		this.session = session;
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
	public String signup(SignupReqDto dto) {
		User user = new User();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		
		userRepository.save(user);
		return "redirect:/loginForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		
		User userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());
		
		if(userEntity == null) {
			return "redirect:/loginForm";
		} else {
			session.setAttribute("principal", userEntity);
			return "redirect:/home";
		}
	}
}
