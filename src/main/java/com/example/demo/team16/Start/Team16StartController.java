package com.example.demo.team16.Start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team16StartController {
	@GetMapping("/start")
	public String index(){
		return "team16/Start/Team16Start";
	}
	
	@PostMapping(value="/game",params="gamestart")
	public String send1() {
		return "kensyu1/game";
	}
	
	@PostMapping(value="/game",params="menu")
	public String send2() {
		return "team16/Menu/Team16Menu";
	}

}
