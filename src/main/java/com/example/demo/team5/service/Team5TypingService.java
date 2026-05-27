package com.example.demo.team5.service;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Service;

@Service
public class Team5TypingService{
	private int correctCount=0,wrongCount=0,totalCount=0;
	private Instant start=null,end=null;
	
	
	//get.正解数
	public int getCorrect() {
		return correctCount;
	}
	//get.間違数
		public int getWrong() {
			return wrongCount;
		}
		
	public double getPer() {
			return calcPer(correctCount,totalCount) ;
		}
	
	///分間打鍵数獲得関数
	public double getcalcM(Instant start,Instant end) {
		return calcMinutes(calcTime(start,end), correctCount);
	}
	
	//以下計算部分
	//分間打鍵数を計測する。
	private double calcMinutes(double time, int correct) {
		//timeが0の場合、エラー値として-1を返す。
		if(time == 0) {
			return -1;
		}else {
			double perMinutes = correct / (time/60);	
		return perMinutes;
	}
	}
	
	//
	private double calcPer(int correct, int total) {
		double doubleCor = (double)correct;
		double doubleTol = (double)total;
		double per = doubleCor / doubleTol;
		//System.out.println(per);
		//System.out.println(correct);
		//System.out.println(total);
		return per;
	}
	
	
	
	//正誤誤判定
	public void checkArticle(String inputText,String sampleText) {
		//x[0]は間違え数
		//x[1]は合計文字数
		correctCount=0;
		wrongCount=0;
		totalCount=0;
		int[] x = {0,0};
		int il = inputText.length();
		int sl = sampleText.length();
		x[1] = sl;
		if(inputText.equals(sampleText)) {
			x[0] = il;
		}else {
			int loopcap;
			if(il < sl) {
				loopcap = il;
			}else {
				loopcap = sl;
			}
			
			for(int i = 0;i < loopcap;i++) {
				if(sampleText.charAt(i) != inputText.charAt(i)) {
					wrongCount++;
				}
			}
			wrongCount += Math.abs(il - sl);
		}
		correctCount = sl - wrongCount;
		totalCount = sl;
	}
	
	//タイマーセット、再度呼び出すと、タイマーストップ
	public void takeTimer() {
		if(start != null && end != null) {
			start = null;
			end = null;
		}
		if(start == null) {
			start = Instant.now();
			System.out.println(start);
			return;
		}else {
			end = Instant.now();
			System.out.println(end);
			return;
		}
	}
	
	
	public Instant getLocalTime() {
		return Instant.now();
	}
	
	
	//現在時刻を取得し、差を計算。ミリ秒から秒に変換するメソッド
	public double calcTime(Instant start,Instant end) {
		Duration duration = Duration.between(start, end);
		double time = Math.round(duration.toMillis()/100.0)/10.0;
		return time;
	}
}