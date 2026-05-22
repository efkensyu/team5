package com.example.demo.team5.service;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Service;

@Service
public class Team5TypingService extends Team5TypingCalcService{
	private int correctCount=0,wrongCount=0,totalCount=0;
	private Instant start=null,end=null;
	
	public double getPer() {
		//System.out.println(correctCount);
		//System.out.println(totalCount);
		return calcPer(correctCount,totalCount) ;
	}
	
	//コンストラクタ呼び出し時に、
	//入力文字列とサンプル文字列を入力させる。
	//checkArticleを動かすために
//	public void Article(String inputText) {
//		//checkArticle(String inputText,String sampleText);
//	}
	//getの呼び出し
	public int getCorrect() {
		return correctCount;
	}
	//getの呼び出し
		public int getWrong() {
			return wrongCount;
		}
	//正誤誤判定
	public void checkArticle(String inputText,String sampleText) {
		//x[0]は間違え数
		//x[1]は合計文字数
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
		System.out.println(duration);
		double time = Math.round(duration.toMillis()/100.0)/10.0;
		return time;
	}
	
	///分間打鍵数
		public double getcalcM(Instant start,Instant end) {
			getLocalTime();
			takeTimer();
			System.out.println(start);
			System.out.println(end);
			return calcMinutes(calcTime(start,end), correctCount);
		}
}
