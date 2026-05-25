package com.example.demo.team16;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="team16_users_tbl")
@Data
public class Team16Entity {
	
	@Id
	private String username;
	//@Column(name="battle_count")
	private Integer battle_count;
	//@Column(name="win_persent")
	private Double win_percent;
	//@Column(name="win_count")
	private Integer win_count;
	

}
