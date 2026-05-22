package com.example.demo.team16.Account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team16.Team16Entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team16AccountController {

	@GetMapping("/account1")	
	public String index(@ModelAttribute Team16AccountForm team16AccountForm ) {	
		return "team16/Account/Team16AccountIn";
	}
	
	@PostMapping("/account1")
	public String createUser(@ModelAttribute @Validated Team16AccountForm team16AccountForm,BindingResult result,Model model ) {
		Team16Entity entity = new Team16Entity();
		entity.setUsername(team16AccountForm.getNewuser());
	
		
		return "team16/Account/Team16AccountOut";
	}

}
