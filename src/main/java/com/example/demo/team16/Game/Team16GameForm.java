package com.example.demo.team16.Game;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team16GameForm {
	public int[][] board ;
	@NotBlank(message = "****黒プレイヤーを入力してください****")
	public String black;
	@NotBlank(message = "****白プレイヤーを入力してください****")
	public String white;
	public int blackCount;
	public int whiteCount;
}
