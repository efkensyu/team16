package com.example.demo.team16.Menu;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Service.Team16GameService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

	@Slf4j
	@Controller
	@RequiredArgsConstructor
	public class  Team16MenuController {
		
		private final Team16GameService team16GameService;
		
		@GetMapping("/Team16Menu")
		public String index(){
			return "team16/Menu/Team16Menu";
		}
		
		@PostMapping("/Team16login")
		public String send() {
			return "team16/Login/Team16LoginIn";
		}
		
		@PostMapping("/Team16runking")
		public String runking(Model model) {
			try {
			List<Team16Entity> runking =team16GameService.findAllByOrderByWinCount();
			int[] t = new int[runking.size()];
			int s=-1;
			int i=0;
			int count=0;
			for(Team16Entity r : runking) {
				if(s!=r.getWinCount()) {
					count=i+1;
				}
				t[i] = count;
				i++;
				s=r.getWinCount();
			}
			model.addAttribute("count",t);
			model.addAttribute("runking",runking);
			return "team16/Menu/Team16Runking";
			}catch(Exception e) {
				return "team16/Team16Error";
			}
		}
		
		
		
	}


