package com.example.demo.team5.service;

import java.util.List;

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
	    
	    public List<Team5Account> findAll(){
	    	return repository.findAll();
	    }
	    public boolean hasLoginId(String inputId) {
	    	if(repository.existsByUserId(inputId)) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    }
	    
	    public boolean canLogin(String Id,String PassWord) {
	    	String UserPass = repository.findByUserId(Id).getPassWord();
	    	if(repository.existsByUserId(Id) && UserPass.equals(PassWord)){
	    		return true;
	    	}else {
	    	return false;
	    }
	    }
//	    public void Addscore(Team5Account account,Integer score) {
//	    	 account.setScore(score);
//	    	 repository.save(account);
//	    }
	    
	}
