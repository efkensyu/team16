package com.example.demo.team16;

import jakarta.persistence.Column;
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
	@Column(name="battle_count")
	private Integer battleCount;
	@Column(name="win_percent")
	private Double winPercent;
	@Column(name="win_count")
	private Integer winCount;
	

}
