package com.example.demo.team16.Account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Team16AccountForm {

	@NotBlank(message = "**アカウント名を入力してください**")
	@Size(min=1,max=10, message ="**1文字以上10文字以下で設定してください**")
	private String username;
	
	
	
	
}
