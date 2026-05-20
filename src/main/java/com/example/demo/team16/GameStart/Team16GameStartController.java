package com.example.demo.team16.GameStart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Team16GameStartController {
	int[][] board =createBoard();
	private int[][] createBoard() {

		int[][] board = new int[8][8];
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
	                board[i][j] = 0;
	            }
	        }
	    board[3][3] = 2;
	    board[3][4] = 1;
	    board[4][3] = 1;
	    board[4][4] = 2;
	        return board;
	 }

    @GetMapping("/GameStart")
    public String black(Model model) {
    	model.addAttribute("board",board);
        return "team16/Game/Team16GameBlack";
    }
}