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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@SessionAttributes("team16GameForm")
public class Team16GameController {
	
	final Team16GameService team16GameService;
	
	Team16GameMethod method = new Team16GameMethod();

    @GetMapping("/Team16Game")
    public String Start(@ModelAttribute Team16GameForm team16GameForm ) {
    	method.createBoard(team16GameForm);
        method.checkBoard(team16GameForm,1,2);
        return "team16/Game/Team16GameBlack";
    }
    
    @PostMapping("/Team16White")
    public String White(@ModelAttribute Team16GameForm team16GameForm ,@RequestParam int x,int y,int n) {
    	try {
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
    	black.setBattleCount(black.getBattleCount()+1);
    	white.setBattleCount(white.getBattleCount()+1);
    	
    	if(t==1) {
    		black.setWinCount(black.getWinCount()+1);
    	}else if(t==2) {
    		white.setWinCount(white.getWinCount()+1);
    	}
    	double win_count=black.getWinCount();
    	double battle_count=black.getBattleCount();
    	black.setWinPercent(win_count/battle_count*100);
    	
    	win_count=white.getWinCount();
    	battle_count=white.getBattleCount();
    	white.setWinPercent(win_count/battle_count*100);
    	
    	team16GameService.save(black);
    	team16GameService.save(white);
    	
    	return "team16/Game/Team16GameResult";
    	}catch(Exception e) {
			return "team16/Team16Error";
		}
    }
    
    @PostMapping("/Team16Black")
    public String Black(@ModelAttribute Team16GameForm team16GameForm,@RequestParam int x,int y,int n) {
    	try {
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
    	black.setBattleCount(black.getBattleCount()+1);
    	white.setBattleCount(white.getBattleCount()+1);
    	
    	if(t==1) {
    		black.setWinCount(black.getWinCount()+1);
    	}else if(t==2) {
    		white.setWinCount(white.getWinCount()+1);
    	}
    	
    	double win_count=black.getWinCount();
    	double battle_count=black.getBattleCount();
    	black.setWinPercent(win_count/battle_count*100);
    	
    	win_count=white.getWinCount();
    	battle_count=white.getBattleCount();
    	white.setWinPercent(win_count/battle_count*100);
    	
    	team16GameService.save(black);
    	team16GameService.save(white);
    	
    	return "team16/Game/Team16GameResult";
    	}catch(Exception e) {
			return "team16/Team16Error";
		}
    }
    
}
