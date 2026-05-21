package com.example.demo.team16.Start;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Game.Team16GameForm;
import com.example.demo.team16.Service.Team16StartService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team16StartController {
	private final Team16StartService team16StartService;
	
	@GetMapping("/start")
	public String index(@ModelAttribute Team16GameForm team16GameForm, Model model){
		List<Team16Entity>userDataBlack = team16StartService. findByUsernameEquals(team16GameForm.black);
		model.addAttribute("userDataBlack",userDataBlack);
		List<Team16Entity>userDataWhite = team16StartService. findByUsernameEquals(team16GameForm.white);
		model.addAttribute("userDataWhite",userDataWhite);
		
		return "team16/Start/Team16Start";
	}
	
	
	
	@PostMapping(value="/game",params="menu")
	public String send2() {
		return "team16/Menu/Team16Menu";
	}

}
