package com.example.demo.team16.Login;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team16LoginForm {
	
	@NotBlank(message = "****黒プレイヤーを入力してください****")
	private String username1;
	
	@NotBlank(message = "****白プレイヤーを入力してください****")
	private String username2;
}
