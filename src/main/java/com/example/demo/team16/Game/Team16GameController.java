package com.example.demo.team16.Game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@SessionAttributes("team16GameForm")
public class Team16GameController {
	Team16GameMethod method = new Team16GameMethod();
	@ModelAttribute("team16GameForm")
		public Team16GameForm setTeam16GameForm(){
			return new Team16GameForm();
		}
	
    @GetMapping("/Game")
    public String Start(@ModelAttribute Team16GameForm team16GameForm ) {
    	
    	method.createBoard(team16GameForm);
        method.checkBoardBlack(team16GameForm);
        return "team16/Game/Team16GameBlack";
    }
    
    @PostMapping("/White")
    public String White(@ModelAttribute Team16GameForm team16GameForm ,@RequestParam int x,int y) {
    	method.setBoardBlack(team16GameForm,x,y);
    	method.checkBoardWhite(team16GameForm);
    	return "team16/Game/Team16GameWhite";
    }
    
    @PostMapping("/Black")
    public String Black(@ModelAttribute Team16GameForm team16GameForm,@RequestParam int x,int y) {
    	method.setBoardWhite(team16GameForm,x,y);
    	method.checkBoardBlack(team16GameForm);
    	return "team16/Game/Team16GameBlack";
    }
    
}
