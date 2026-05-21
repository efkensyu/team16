package com.example.demo.team16.Start;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Service.Team16StartService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team16StartController {
	private final Team16StartService team16StartService;
	
	@GetMapping("/start")
	public String index(@RequestParam String black,String white,Model model){
		List<Team16Entity>userData = team16StartService.findAll();
		model.addAttribute("userDataList",userData);
		model.addAttribute("black",black);
		model.addAttribute("white",white);
		return "team16/Start/Team16Start";
	}
	
	
	
	@PostMapping(value="/game",params="menu")
	public String send2() {
		return "team16/Menu/Team16Menu";
	}

}
