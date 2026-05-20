package com.example.demo.team5.service;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Service;

@Service
public class Team5TypeingService {
	
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
