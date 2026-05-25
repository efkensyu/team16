package com.example.demo.team16.Account;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Game.Team16GameForm;
import com.example.demo.team16.Service.Team16LoginsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class Team16AccountController {
	private final Team16LoginsService team16LoginService;

	@GetMapping("/account1")	
	public String index(@ModelAttribute Team16AccountForm team16AccountForm ) {	
		return "team16/Account/Team16AccountIn";
	}
	
	@PostMapping("/account1")
	public String createUser( @Validated @ModelAttribute Team16AccountForm team16AccountForm,BindingResult result,Model model ) {
		
		if(result.hasErrors()) {
			return "team16/Account/Team16AccountIn";
		}
		
		Team16Entity team16Entity = new Team16Entity();
		String newname = team16AccountForm.getUsername();
		List<Team16Entity> userList = team16LoginService.findByUsernameEquals(newname);
		
		if(userList.isEmpty()) {
			team16Entity.setUsername(newname);
			team16Entity.setBattleCount(0);
			team16Entity.setWinCount(0);
			team16Entity.setWinPercent(0.000);
			team16LoginService.save(team16Entity);
			
			return "redirect:/login1";
		}else {
			model.addAttribute("message","**既に使用されているアカウント名です**");
		}	
		return "team16/Account/Team16AccountIn";
	}
	
	@PostMapping(value = "/account1", params = "back")
	public String sendLogin(@ModelAttribute Team16GameForm team16GameForm){
		return "redirect:/login1";
	}

}
