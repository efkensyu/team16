package com.example.demo.team16.Menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


	@Controller
	public class  Team16MenuController {
		@GetMapping("/Team16Menu")
		public String index(){
			return "team16/Menu/Team16Menu";
		}
		
		@PostMapping("/login")
		public String send() {
			return "team16/Login/Team16LoginIn";
		}
	}


