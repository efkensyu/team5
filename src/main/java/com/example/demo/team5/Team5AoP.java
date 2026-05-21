package com.example.demo.team5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
		log.warn("Postメソッドのwarningログ");
		log.error("Postメソッドのwarningログ");
	}
	@After("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public void AfterLog1(JoinPoint jp) {
		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
		log.info("getメソッドのinfoログ");
		log.warn("getメソッドのwarningログ");
		log.error("getメソッドのwarningログ");
	}

}
