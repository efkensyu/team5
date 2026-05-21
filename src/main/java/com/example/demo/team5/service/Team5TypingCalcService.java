package com.example.demo.team5.service;

import org.springframework.stereotype.Service;

@Service
public class Team5TypingCalcService{
	
	
	
	//正解確率を出力する。
	//引数は（正解文字数,合計文字数)
	public double calcPer(int correct, int total) {
	double per = correct / total;
	return per;
	
}
	//分間打文字数を出力する。
	//引数は（時間、正解文字数）
	public double calcMinutes(double time, int correct) {
		//timeが0の場合、エラー値として-1を返す。
		if(time == 0) {
			return -1;
		}else {
			double perMinutes = correct / (time/60);	
		return perMinutes;
	}
	
		
}
}