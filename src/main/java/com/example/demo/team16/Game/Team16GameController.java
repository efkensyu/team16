package com.example.demo.team16.Game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Service.Team16GameService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@SessionAttributes("team16GameForm")
public class Team16GameController {
	
	final Team16GameService team16GameService;
	
	Team16GameMethod method = new Team16GameMethod();

    @GetMapping("/Game")
    public String Start(@ModelAttribute Team16GameForm team16GameForm ) {
    	
    	method.createBoard(team16GameForm);
        method.checkBoard(team16GameForm,1,2);
        return "team16/Game/Team16GameBlack";
    }
    
    @PostMapping("/White")
    public String White(@ModelAttribute Team16GameForm team16GameForm ,@RequestParam int x,int y,int n) {
    	int t;
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
    	t=method.resultBoard(team16GameForm);
    	
    	Team16Entity black = team16GameService.findByUsernameEquals(team16GameForm.black); 
    	Team16Entity white = team16GameService.findByUsernameEquals(team16GameForm.white);
    	black.setBattle_count(black.getBattle_count()+1);
    	white.setBattle_count(white.getBattle_count()+1);
    	
    	if(t==1) {
    		black.setWin_count(black.getWin_count()+1);
    	}else if(t==2) {
    		white.setWin_count(white.getWin_count()+1);
    	}
    	double win_count=black.getWin_count();
    	double battle_count=black.getBattle_count();
    	black.setWin_percent(win_count/battle_count);
    	
    	win_count=white.getWin_count();
    	battle_count=white.getBattle_count();
    	white.setWin_percent(win_count/battle_count);
    	
    	team16GameService.save(black);
    	team16GameService.save(white);
    	
    	return "team16/Game/Team16GameResult";
    }
    
    @PostMapping("/Black")
    public String Black(@ModelAttribute Team16GameForm team16GameForm,@RequestParam int x,int y,int n) {
    	int t;
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
    	t=method.resultBoard(team16GameForm);
    	
    	Team16Entity black = team16GameService.findByUsernameEquals(team16GameForm.black); 
    	Team16Entity white = team16GameService.findByUsernameEquals(team16GameForm.white);
    	black.setBattle_count(black.getBattle_count()+1);
    	white.setBattle_count(white.getBattle_count()+1);
    	
    	if(t==1) {
    		black.setWin_count(black.getWin_count()+1);
    	}else if(t==2) {
    		white.setWin_count(white.getWin_count()+1);
    	}
    	
    	double win_count=black.getWin_count();
    	double battle_count=black.getBattle_count();
    	black.setWin_percent(win_count/battle_count);
    	
    	win_count=white.getWin_count();
    	battle_count=white.getBattle_count();
    	white.setWin_percent(win_count/battle_count);
    	
    	team16GameService.save(black);
    	team16GameService.save(white);
    	
    	return "team16/Game/Team16GameResult";
    }
    
}
