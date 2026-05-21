package com.example.demo.team5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Team5AoP {
	@After("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void AfterLog(JoinPoint jp) {
		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
		log.info("Postメソッドのinfoログ");
		
	}
	@AfterThrowing("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void AfterTGLog(JoinPoint jp) {
		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
		
		log.error("Postメソッドのerrorログ");
	}
	@After("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void AfterLog1(JoinPoint jp) {
		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
		log.info("getメソッドのinfoログ");
		
		
	}
	@AfterThrowing("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void AfterTPLog1(JoinPoint jp) {
		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
		
		log.error("getメソッドのerrorログ");
	}

}
