package com.example.demo.team5.service;

import org.springframework.stereotype.Service;

import com.example.demo.team5.entity.Team5Acount;
import com.example.demo.team5.repository.Team5AcountRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Team5AcountService {
	


	    private final Team5AcountRepository team5AcountRepository;

	    public void create(String LoginId, String PassWord) {
	    	Team5Acount team5Acount = new Team5Acount();
	    	 team5Acount.setLoginId(LoginId);

	       // return "success!!";
	    	 team5Acount.setPassWord(PassWord);
	    	 team5AcountRepository.save(team5Acount);
	    	 System.out.println(team5AcountRepository.findAll());
	    }
	}
