package com.example.demo.team5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Team5AoP {
	@Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
	public Object AfterLog(ProceedingJoinPoint jp) throws Throwable{
		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
		System.out.println("[Around]postメソッド開始:" + jp.getSignature());
		Object result;
		try {result = jp.proceed();
		}catch(Exception e) {
			log.error("Postメソッドのerrorログ");
			return "team5/Team5error";	
		}
		//メソッド実行　indexが動いたら
		System.out.println("[Around]postメソッド終了:" + jp.getSignature());
		log.info("Postメソッドのinfoログ");
		return result;
	}
//	@AfterThrowing("@annotation(org.springframework.web.bind.annotation.PostMapping)")
//	public Object AfterTGLog(JoinPoint jp) {
//		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
//		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
//		
//		log.error("Postメソッドのerrorログ");
//		return "team5/Team5error";	
	//}
	@Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	public Object AroundLog(ProceedingJoinPoint jp) throws Throwable{
		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
		System.out.println("[Around]getメソッド開始:" + jp.getSignature());
		Object result;
		try {result = jp.proceed();
		}catch(Exception e) {
			log.error("Getメソッドのerrorログ");
			return "team5/Team5error";	
		}
		//メソッド実行　indexが動いたら
		System.out.println("[Around]Getメソッド終了:" + jp.getSignature());
		log.info("Getメソッドのinfoログ");
		return result;
		
		
	}
//	@AfterThrowing("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//	public  Object AfterTPLog1(JoinPoint jp) {
//		//System.out.println("[After]PotMappingメソッド開始:" + jp.getSignature());
//		//System.out.println("送ったデータ:" + Arrays.toString(jp.getArgs()));
//		
//		log.error("getメソッドのerrorログ");
//		
//		return "team5/Team5error";	
//	}

}
