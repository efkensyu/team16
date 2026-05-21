package com.example.demo.team16.Account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team16.Login.Team16LoginForm;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team16AccountController {

	@GetMapping("/account1")	
	public String index(@ModelAttribute Team16LoginForm team16LoginForm ) {	
		return "team16/Account/Team16AccountIn";
	}
	
	@PostMapping("/account1")
	public String createUser(@ModelAttribute Team16LoginForm team16LoginForm ) {
		
		
		return "team16/Account/Team16AccountOut";
	}

}
