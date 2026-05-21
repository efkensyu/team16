package com.example.demo.team16.Login;

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
import com.example.demo.team16.Service.Team16StartService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller

public class Team16LoginController {
	private final Team16LoginsService team16LoginsService;
	private final Team16StartService team16StartService;
		@GetMapping("/login1")	
		public String index(@ModelAttribute Team16GameForm team16GameForm ) {	
			return "team16/Login/Team16LoginIn";
		}
		
		@PostMapping("/login1")	
		public String send(@ModelAttribute @Validated Team16GameForm team16GameForm,BindingResult result,Model model) {
			
			if(result.hasErrors()) {
				return "team16/Login/Team16LoginIn";
			}
			
			List<Team16Entity> blackPlayer = team16LoginsService.findByUsernameEquals(team16GameForm.getBlack());
			List<Team16Entity> whitePlayer = team16LoginsService.findByUsernameEquals(team16GameForm.getWhite());
			
			if(blackPlayer.isEmpty() && whitePlayer.isEmpty()) {

		        model.addAttribute("message1",
		                "****黒プレイヤーが存在しません****");
		        model.addAttribute("message2",
		                "****白プレイヤーが存在しません****");

		        return "team16/Login/Team16LoginIn";
		    }
			
			
			if(blackPlayer.isEmpty()) {

		        model.addAttribute("message1",
		                "****黒プレイヤーが存在しません****");

		        return "team16/Login/Team16LoginIn";
		    }
			
			
			if(whitePlayer.isEmpty()) {

		        model.addAttribute("message2",
		                "****白プレイヤーが存在しません****");

		        return "team16/Login/Team16LoginIn";
		    }
			
			
			 
			 if(team16GameForm.getBlack()
			            .equals(team16GameForm.getWhite()))  {
			        model.addAttribute("message", "****同じユーザーは選べません****");
			        return "team16/Login/Team16LoginIn";
			    }
			 List<Team16Entity>userDataBlack = team16StartService. findByUsernameEquals(team16GameForm.black);
				model.addAttribute("userDataBlack",userDataBlack);
				List<Team16Entity>userDataWhite = team16StartService. findByUsernameEquals(team16GameForm.white);
				model.addAttribute("userDataWhite",userDataWhite);
			model.addAttribute("blackPlayer", blackPlayer);
			model.addAttribute("whitePlayer", whitePlayer);
			return "team16/Start/Team16Start";
		}
	
 
	

}
