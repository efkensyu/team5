package com.example.demo.team5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.team5.service.Team5Service;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class test {
	private final Team5Service typing;
	
	
	@GetMapping("Team5/flowRear/test")		
	public String index () {		
		System.out.println("確認");
		System.out.println(typing.getTypingBody());
		
		return "team5/Team5login";	
	}		
	

}
