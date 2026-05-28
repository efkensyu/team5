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
	    String bar = "‐";
	    
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
	    	Team5Account findByUserId = repository.findByUserId(Id);
	    	if(findByUserId != null && findByUserId.getPassWord().equals(PassWord)){
	    		return true;
	    	}else {
	    	return false;
	    }
	    }
	    
	    public void addScore(Team5Account account,Integer score) {
	    	Integer nowScore = account.getScore();
	    	if(nowScore != null && nowScore > score) {
	    		return;
	    	}
	    	account.setScore(score);
	    	repository.save(account);
	    }
	    
	    public List<Team5Account> getTop5Accounts(){
	    	return repository.findTop5ByOrderByScoreDesc();
	    }
	    
	    //debug
	    public void createDummyAccount(int num) { 
	    	if(repository.count() > num) {
	    		return;
	    	}
	    	for(int i = 0;i < num;i++) {
	    		Team5Account dummy = new Team5Account();
	    		dummy.setUserId("dummy" + i);
	    		dummy.setPassWord("dummydummy" + i);
	    		dummy.setScore(i);
	    		create(dummy);
	    	}
	    }
	    

	    
	    public String getRanking(int score) {
	    	List<Team5Account> rankings = repository.findByOrderByScoreDesc();
	    	
	    	for(int i = 0 ; i < rankings.size();i++) {
	    		if(rankings.get(i).getScore() == null) {
	    			return bar;
	    		}
	    		if(rankings.get(i).getScore() <= score) {
	    			Integer tmp = i+1;
	    			return tmp.toString();
	    		}
	    	}
	    	return bar;
	    }
	    
	    public String getRanking(Team5Account account) {
	    	if(account.getScore() == null) {
	    		return bar;
	    	}
	    	int score = account.getScore();
	    	List<Team5Account> rankings = repository.findByOrderByScoreDesc();
	    	
	    	for(int i = 0 ; i < rankings.size();i++) {
	    		if(rankings.get(i).getScore() == null) {
	    			return bar;
	    		}
	    		if(rankings.get(i).getScore() <= score) {
	    			Integer tmp = i+1;
	    			return tmp.toString();
	    		}
	    	}
	    	return bar;
	    }
	    
	    public Team5Account getAccount(String id) {
	    	return repository.findByUserId(id);
	    			}
	    
	    
	}
