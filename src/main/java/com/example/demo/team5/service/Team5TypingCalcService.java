package com.example.demo.team5.service;

import org.springframework.stereotype.Service;

@Service
public class Team5TypingCalcService{
	
	
	
	//正解確率を出力する。
	public double calcPer(String inputText, String totalText) {
	double per = inputText.length() / totalText.length();
	return per;
	
}
	//分間打文字数を出力する。
	public double calcMinutes(double time, String correct) {
		//timeが0の場合、エラー値として-1を返す。
		if(time == 0) {
			return -1;
		}else {
			double perMinutes = correct.length() / (time/60);	
		return perMinutes;
	}
	
		
}
}