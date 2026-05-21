package com.example.demo.team5;

import java.time.Instant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team5.service.Team5TypingService;


@Controller	
public class Team5Controller {
public static Instant start,end;
public Team5TypingService typing;

//ログイン画面
	//ログイン画面へ
		@GetMapping("/Team5/login")		
		public String index () throws Throwable{	
			System.out.println("確認");
			
			return "team5/Team5login";	
		}		
		
		//ログイン画面からメニュー画面へ
		@PostMapping(value ="/Team5/menu" ,params = "next")		
		public String send1() throws Throwable{
			System.out.println("login to menu");
			return "team5/Team5menu";	
		}
	//メニュー画面処理
		//メニュー画面からタイピング画面へ
		@PostMapping(value ="/Team5/typi",params="next")		
		public String send2(Model model) throws Throwable{
			System.out.println("menu to typing");
			return "team5/Team5typing";	
		}
		//タイピング画面からメニュー画面へ
		@PostMapping(value ="/Team5/menu",params="return")	
		public String send02() {
					
				return "team5/Team5menu";	
		}
				
				
	//メイン処理部分
	//文字入力を受け取り、時間計測を開始する部分。
	//セッション時間計測を開始させる。
		//タイピング画面からタイピング実施画面へ
		@PostMapping(value ="/Team5/uchikomi",params="clear")		
		public String send3()throws Throwable {
			start = typing.getLocalTime();
			//start = Team5TypeingService.getLocalTime();
			return "team5/Team5uchikomi";
		}
		
		//タイピング実施画面からタイピング画面へ
		@PostMapping(value ="/Team5/typi",params="return")	
		public String send03(Model model) {
			System.out.println("戻る");
			return "team5/Team5typing";	
		}
		
		//タイピング実施画面から結果画面へ
		//計測終了
		@PostMapping(value ="/Team5/result",params="next")		
		public String send5(@RequestParam String inputText,Model model) {
			end = typing.getLocalTime();
			model.addAttribute("inputText",inputText);
			return "team5/Team5result";
		}
//タイピング実施画面 to 結果画面
//
//		@PostMapping(value ="/Team5/result",params="next")		
//		public String send7(@ModelAttribute Team5Entity team5Entity,Model model) {
//			model.addAttribute("inputEntity",team5Entity);
//			return "team5/Team5result";
//		}
		
		
		//タイピング結果画面からメニュー画面へ
		@PostMapping(value ="/Team5/result1",params="next")		
		public String send4() {
	
			return "team5/Team5menu";		
			}


}
