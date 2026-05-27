package com.example.demo.team5.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.team5.entity.Team5_typing;
import com.example.demo.team5.repository.Team5TypingRepository;

@Service
public class Team5Service {
	@Autowired
	private Team5TypingRepository typing;
	
	Random random = new Random();
	
	public  List<Team5_typing> getTypingBody() {
		Integer id = (random.nextInt(typing.findAll().size())+1);
		return typing.findByTypingId(id);
	}
	
	
	
	
	
	
}
