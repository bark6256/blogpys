package com.example.blogpys.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	private HttpServletResponse response;

	public UserController(UserRepository userRepository, HttpSession session,
			HttpServletResponse response,
			HttpServletRequest request) {
		this.userRepository = userRepository;
		this.session = session;
		this.response = response;
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
		if (dto.isRemember()) {
			Cookie myCookie = new Cookie("username", dto.getUsername());
			myCookie.setMaxAge(-1);
			response.addCookie(myCookie);
		} else {
			Cookie myCookie = new Cookie("username", null);
			myCookie.setMaxAge(0);
			response.addCookie(myCookie);
		}
		User userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());

		if (userEntity == null) {
			return "redirect:/loginForm";
		} else {
			session.setAttribute("principal", userEntity);
			return "redirect:/home";
		}
	}

	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/home";
	}

	@GetMapping("/userInfoForm")
	public String useriInfoForm() {
		return "user/userInfoForm";
	}
}
