package com.example.demo.team5.service;

import org.springframework.stereotype.Service;

import com.example.demo.team5.entity.Team5Account;
import com.example.demo.team5.repository.Team5AccountRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Team5AccountService {
	


	    private final Team5AccountRepository team5AccountRepository;

	    public void create(String LoginId, String PassWord) {
	    	Team5Account team5Account = new Team5Account();
	    	 team5Account.setLoginId(LoginId);

	       // return "success!!";
	    	 team5Account.setPassWord(PassWord);
	    	 team5AccountRepository.save(team5Account);
	    	 System.out.println(team5AccountRepository.findAll());
	    }
	}
