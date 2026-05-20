package com.example.demo.team5.service;

import org.springframework.stereotype.Service;

@Service
public class Team5TypingCalcService {
	//入力された文字数をdouble型にして正解率（per）を出す。
	private double per;
	private double perMinutes;
	
	public double calcPer(String correct, String total) {
	per= correct.length() / total.length();
	return per;
	
}
	
	public double calcMinutes(double time, String correct) {
		perMinutes = correct.length() / (time/60);
		if(time == 0) {
			return -1;
		}else {
		return perMinutes;
	}
}
}