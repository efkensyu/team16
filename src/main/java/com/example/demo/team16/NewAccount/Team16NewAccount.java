package com.example.demo.team16.NewAccount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team16.Account.Team16AccountForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Team16NewAccount {

	@GetMapping("/Team16New1")	
	public String index(@ModelAttribute Team16AccountForm team16AccountForm ) {	
		return "team16/NewAccount/Team16NewAccountIn";
	}
	
	
	@PostMapping("/Team16New1")
	public String sendLogin(@ModelAttribute Team16AccountForm team16AccountForm){	
		return "redirect:/Team16login1";
	}
	
}
