package com.example.demo.team5.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class test {
	
	@GetMapping("ensyu2")		
	public String index () {		
		System.out.println("確認");
		
		return "team5/Team5login";	
	}		
	

}
