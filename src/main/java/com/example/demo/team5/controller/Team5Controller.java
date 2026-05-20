package com.example.demo.team5.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



public class Team5Controller {


	//ログイン画面へ
		@GetMapping("/Team5/login")		
		public String index () {		
			
			
			return "templates.team5/Team5login";	
		}		
		
		//ログイン画面からメニュー画面へ
		@PostMapping(value ="/Team5/menu" ,params = "next")		
		public String send1() {	

			
				
			return "templates.team5/Team5menu";	
		}		
		//メニュー画面からタイピング画面へ
		@PostMapping(value ="/Team5/typi",params="next")		
		public String send2(Model model) {
			
			return "templates.team5/Team5typing";	
		}
		//タイピング画面からメニュー画面へ
				@PostMapping(value ="/Team5/menu",params="return")	
				public String send02(Model model) {
					
					return "templates.team5/Team5menu";	
				}
				
				
		
		//タイピング画面からタイピング実施画面へ
		@PostMapping(value ="/Team5/uchikomi",params="clear")		
		public String send3() {
			
			
			return "templates.team5/Team5uchikomi";
		
	
	}
		//タイピング実施画面からタイピング画面へ
		@PostMapping(value ="/Team5/typi",params="return")	
		public String send03(Model model) {
			
			return "templates.team5/Team5typing";	
		}
		//タイピング実施画面から結果画面へ
		@PostMapping(value ="/Team5/result",params="next")		
		public String send5() {
			
			
			return "templates.team5/Team5result";
		
		}
		//タイピング結果画面からメニュー画面へ
				@PostMapping(value ="/Team5/menu",params="next")		
				public String send4() {
					
					
					return "templates.team5/Team5menu";
				
			
			}


}
