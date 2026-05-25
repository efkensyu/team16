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
			log.info("メニュー画面:Getメソッド実行");
			return "team16/Menu/Team16Menu";
		}
		
		@PostMapping("/Team16login")
		public String send() {
			log.info("メニュー画面:Postメソッド実行");
			return "team16/Login/Team16LoginIn";
		}
		
		@PostMapping("/Team16runking")
		public String runking(Model model) {
			List<Team16Entity> runking =team16GameService.findAllByOrderByWinCount();
			model.addAttribute("runking",runking);
			log.info("メニュー画面:Postソッド実行");
			return "team16/Menu/Team16Runking";
		}
		
		
		
	}


