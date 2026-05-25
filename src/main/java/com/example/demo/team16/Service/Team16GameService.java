package com.example.demo.team16.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Repository.Team16GameRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team16GameService {
	private final Team16GameRepository repository;
	
	public Team16Entity findByUsernameEquals(String username){
		return repository.findByUsernameEquals(username);	
	}
	
    public void save(Team16Entity entity){
        repository.save(entity);
    }
    
    public List<Team16Entity> findAllByOrderByWinCount(){
    	return repository.findAllByOrderByWinCount();
    }

	
}
