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
	private Integer battle_count;
	private Double win_percent;
	private Integer win_count;
	

}
