package com.example.demo.team16.Login;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Service.Team16LoginsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team16LoginController {
	private final Team16LoginsService team16LoginsService;
	
		@GetMapping("/login1")	
		public String index(Model model) {	
			return "team16/Login/Team16LoginIn";
		}
		
		@PostMapping("/login1")	
		public String send(@RequestParam String username,Model model) {	
			List<Team16Entity> userDataList = team16LoginsService.findByUsernameEquals(username);
			
			System.out.println(userDataList);
			model.addAttribute("userDataList", userDataList);
			return "team16/Login/Team16LoginOut";
		}
	
 
	

}
