package com.example.demo.team16.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Repository.Team16LoginRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class Team16LoginsService {
	private final Team16LoginRepository repository;
	
	public List<Team16Entity> findByUsernameEquals(String username){
		return repository.findByUsernameEquals(username);	
	}
	
	public void save(Team16Entity entity) {
		 repository.save(entity);
	}
	
	

}
