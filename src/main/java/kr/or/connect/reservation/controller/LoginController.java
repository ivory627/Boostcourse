package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.reservation.service.UserService;

@Controller
public class LoginController {
	
	private final UserService userService;
	
	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/loginform")
	public String loginform() {
		return "/loginform";
	}
	
	@RequestMapping("/loginerror")
	public String loginerror(@RequestParam("login_error")String loginError) {
		return "/loginerror";
	}

}
