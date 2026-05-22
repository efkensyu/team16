package com.example.demo.team16.Account;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team16AccountForm {

	@NotBlank(message = "****アカウント名を入力してください****")
	private String newuser;
	
}
