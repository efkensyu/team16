package com.example.demo.team16.Game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//

@Controller
@SessionAttributes("team16GameForm")
public class Team16GameController {
	
	Team16GameMethod method = new Team16GameMethod();
	
	
    @GetMapping("/Game")
    public String Start(@ModelAttribute Team16GameForm team16GameForm ) {
    	
    	method.createBoard(team16GameForm);
        method.checkBoard(team16GameForm,1,2);
        return "team16/Game/Team16GameBlack";
    }
    
    @PostMapping("/White")
    public String White(@ModelAttribute Team16GameForm team16GameForm ,@RequestParam int x,int y,int n) {
    	if(n !=3) {
    		return "team16/Game/Team16GameBlack";
    	}
    	method.setBoard(team16GameForm,x,y,1,2);
    	boolean pass2=method.checkBoard(team16GameForm,2,1);
    	if(pass2) {
    		return "team16/Game/Team16GameWhite";
    	}
    	else{
    		method.resetBoard(team16GameForm);
    		boolean pass3=method.checkBoard(team16GameForm,1,2);
    		if(pass3) {
    			return "team16/Game/Team16GameBlack";
    		}
    	}
    	method.resultBoard(team16GameForm);
    	return "team16/Game/Team16GameResult";
    }
    
    @PostMapping("/Black")
    public String Black(@ModelAttribute Team16GameForm team16GameForm,@RequestParam int x,int y,int n) {
    	
    	if(n !=3) {
    		return "team16/Game/Team16GameWhite";
    	}
    	method.setBoard(team16GameForm,x,y,2,1);
    	boolean pass2=method.checkBoard(team16GameForm,1,2);
    	if(pass2) {
    		return "team16/Game/Team16GameBlack";
    	}
    	else{
    		method.resetBoard(team16GameForm);
    		boolean pass3=method.checkBoard(team16GameForm,2,1);
    		if(pass3) {
    			return "team16/Game/Team16GameWhite";
    		}
    	}
    	method.resultBoard(team16GameForm);
    	return "team16/Game/Team16GameResult";
    }
    
}
