package com.example.demo.team16.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team16.Team16Entity;

@Repository
public interface Team16LoginRepository extends JpaRepository<Team16Entity,String>{
	public List<Team16Entity> findByUsernameEquals(String username);
	
	
}
