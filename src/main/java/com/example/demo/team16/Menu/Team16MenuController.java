package com.example.demo.team16.Menu;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Service.Team16GameService;

import lombok.RequiredArgsConstructor;


	@Controller
	@RequiredArgsConstructor
	public class  Team16MenuController {
		
		private final Team16GameService team16GameService;
		
		@GetMapping("/Team16Menu")
		public String index(){
			return "team16/Menu/Team16Menu";
		}
		
		@PostMapping("/login")
		public String send() {
			return "team16/Login/Team16LoginIn";
		}
		
		@PostMapping("/runking")
		public String runking(Model model) {
			List<Team16Entity> runking =team16GameService.findAllByOrderByWinCount();
			model.addAttribute("runking",runking);
			return "team16/Menu/Team16Runking";
		}
		
		
		
	}


