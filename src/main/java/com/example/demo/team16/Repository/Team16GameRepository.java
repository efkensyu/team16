package com.example.demo.team16.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team16.Team16Entity;

@Repository
public interface Team16GameRepository extends JpaRepository<Team16Entity,String>{
	public Team16Entity findByUsernameEquals(String username);
	public List<Team16Entity> findAllByOrderByWinCount();
}

