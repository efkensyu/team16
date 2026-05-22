package com.example.demo.team16.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team16.Team16Entity;
import com.example.demo.team16.Repository.Team16AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Team16AccountService {
	private final Team16AccountRepository repository;
	
	public List<Team16Entity> save(String newuser){
		return repository.save(newuser);
	}
	
}

