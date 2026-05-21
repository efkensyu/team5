package com.example.demo.team5.service;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Service;

@Service
public class Team5TypingService extends Team5TypingCalcService{
	
	//正誤誤判定
	public int[] checkArticle(String inputText,String sampleText) {
		int[] x = {0,0};
		int il = inputText.length();
		int sl = sampleText.length();
		x[1] = sl;
		int wrongCount = 0;
		if(inputText.equals(sampleText)) {
			x[0] = il;
		}else {
			int loopcap;
			if(il > sl) {
				loopcap = il;
			}else {
				loopcap = sl;
			}
			
			for(int i = 0;i < loopcap;i++) {
				if(inputText.charAt(i) != inputText.charAt(i)) {
					wrongCount++;
				}
			}
			wrongCount += Math.abs(il - sl);
			x[0] = wrongCount;
		}
		return x;
	}
	
	//時間管理
	public Instant getLocalTime() {
		return Instant.now();
	}
	
	
	//現在時刻を取得し、差を計算。ミリ秒から秒に変換するメソッド
	public double calcTime(Instant start, Instant end) {
		Duration duration = Duration.between(start, end);
		double time = duration.toMillis() / 1000;
		return time;
	}
	
	
	
	
	
}
