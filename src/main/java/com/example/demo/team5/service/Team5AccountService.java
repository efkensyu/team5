package com.example.demo.team5.service;

import org.springframework.stereotype.Service;

import com.example.demo.team5.entity.Team5Account;
import com.example.demo.team5.repository.Team5AccountRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Team5AccountService {
	    private final Team5AccountRepository repository;

	    public void create(Team5Account account) {
	    	 repository.save(account);
	    }
	    
	    public boolean hasLoginId(String inputId) {
	    	if(repository.findByUserId(inputId)) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    }
	    
	    public boolean canLogin(String Id,String PassWord) {
	    	String UserPass = repository.findByPassWord(Id).getPassWord();
	    	if(repository.findByUserId(Id) && UserPass.equals(PassWord)){
	    		return true;
	    	}else {
	    	return false;
	    }
	    }
	}
