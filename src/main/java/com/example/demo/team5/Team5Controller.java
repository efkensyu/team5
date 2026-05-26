package com.example.demo.team5;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.team5.entity.Team5Account;
import com.example.demo.team5.entity.Team5Validation;
import com.example.demo.team5.service.Team5AccountService;
import com.example.demo.team5.service.Team5Service;
import com.example.demo.team5.service.Team5TypingService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@SessionAttributes("team5Account")
public class Team5Controller {
public static Instant start,end;
String sample;

private final Team5TypingService typing;
private final Team5Service typeServ;
private final Team5AccountService accountServ;


@ModelAttribute("team5Account")
public Team5Account setupAccount() {
	return new Team5Account();
}

//ログイン画面
	//最初の画面へ
		@GetMapping("/Team5/login")		
		public String index () throws Throwable{	
			System.out.println("確認");
			//Debug
			accountServ.createDummyAccount(10);
			
			return "team5/Team5login";	
		}		
		
		//最初の画面からログイン画面へ
		@PostMapping(value ="/Team5/login2" ,params = "login")		
		public String send1() throws Throwable{
			System.out.println("login to login2");
			return "team5/Team5login2";	
		}
		
	
		

		
	//ログイン画面から戻る
		@PostMapping(value ="/Team5/loginback" ,params = "loginback")		
		public String loginback() throws Throwable{
			System.out.println("login2 to login");
			return "team5/Team5login";	
				}
		
	//ログイン（入力）画面からメニュー画面
	//ログイン本体の処理を記入する。
		@PostMapping(value ="/Team5/menu" ,params = "menu")		
		public String login(@ModelAttribute("team5Account") Team5Account team5Account,SessionStatus status,Model model) throws Throwable{
			System.out.println(accountServ.findAll());
			System.out.println(team5Account);
			if(accountServ.canLogin(team5Account.getUserId(),team5Account.getPassWord())) {
				return "team5/Team5menu";
			}else {
				model.addAttribute("logged",-1);
				status.setComplete();
				return "team5/Team5login2";
			}
		}		
		
		
		
	//新規登録画面から戻る
		@PostMapping(value ="/Team5/tourokuback" )		
		public String tourokuback() throws Throwable{
			System.out.println("login2 to login");
			return "team5/Team5login";	
				}					
	//新規登録画面からメニュー画面
				
		@PostMapping(value ="/Team5menu" )		
		public String menu2() throws Throwable{
			System.out.println("touroku to menu");
			return "team5/Team5menu";	
			
		}
		
		
		

		@PostMapping(value = "/Team5/touroku", params = "touroku")
	    public String touroku(Team5Validation team5Validation) {
	        System.out.println("login to touroku");
	        return "team5/Team5touroku";
	    }

	    // 2. 【修正】新規登録画面で「登録」ボタンが押されたときの処理
	    // 送信先のパスを "/Team5/tourokuExecute" に変更します
	    @PostMapping("/Team5/tourokuExecute")
	    public String tourokuExecute(
	    		@Validated @ModelAttribute Team5Account team5Account, 
	    								BindingResult result,
	    								Model model,
	    								SessionStatus status) throws Throwable {
	    	// 入力エラーがあれば、登録画面（Team5touroku.html）に戻す
	        if (result.hasErrors()) {
	        	System.out.println(result);
	        	status.setComplete();
	            return "team5/Team5touroku";
	        }
	      //UserIdに重複があれば、戻す。
	        if(accountServ.hasLoginId(team5Account.getUserId())) {
	        	model.addAttribute("isDuplicated",-1);
	        	System.out.println("test");
	        	status.setComplete();
	        	return "team5/Team5touroku";
	        }
	        //両方問題なければ追加
	        accountServ.create(team5Account);
	        model.addAttribute("team5Account",team5Account);
	        System.out.println(accountServ.findAll());
	        return "team5/Team5menu"; 
	    }
	    
		
	//メニュー画面処理
		//メニュー画面からタイピング画面へ
		@PostMapping(value ="/Team5/typi",params="next")		
		public String send2(Model model) throws Throwable{
			System.out.println("menu to typing");
			return "team5/Team5typing";	
		}
		//メニュー画面からランキング画面へ
				@PostMapping(value ="/Team5/ranking",params="result")		
				public String sendrank(Model model) throws Throwable{
					List<Team5Account> rank = accountServ.getTop5Accounts();
					model.addAttribute("ranking",rank);
					//rankingへの値を渡す。
					
					System.out.println("menu to rankings");
					return "team5/Team5ranking";	
				}
				//ランキング画面からメニュー画面へ
				@PostMapping(value ="/Team5/rankingback",params="return")		
				public String sendmenu(Model model) throws Throwable{
					System.out.println("ranking to menu");
					return "team5/Team5menu";	
				}
		//メニュー画面からログアウトを行う
		//遷移は
		@PostMapping(value ="/Team5/logout",params="logout" )		
		public String logout(SessionStatus status) throws Throwable{
			status.setComplete();
			return "team5/Team5login";	
					}	
		
		
		//タイピング画面からメニュー画面へ
		@PostMapping(value ="/Team5/menu",params="return")	
		public String send02() throws Throwable{
					
				return "team5/Team5menu";	
		}
				
				
	//メイン処理部分
	//文字入力を受け取り、時間計測を開始する部分。
	//セッション時間計測を開始させる。
		//タイピング画面からタイピング実施画面へ
		@PostMapping(value ="/Team5/uchikomi",params="clear")		
		public String send3(Model model)throws Throwable {
			sample = typeServ.getTypingBody().get(0).getTypingBody();
			model.addAttribute("reibun",sample);
			start = typing.getLocalTime();
			//typing.takeTimer();
			System.out.println(start);
				return "team5/Team5uchikomi";
			//start = Team5TypeingService.getLocalTime();
		}
		
		//タイピング実施画面からタイピング画面へ
		@PostMapping(value ="/Team5/typi",params="return")	
		public String send03(Model model)throws Throwable {
			System.out.println("戻る");
			//throw new Exception();
			return "team5/Team5typing";	
		}
		
		//タイピング実施画面から結果画面へ
		//計測終了
		@PostMapping(value ="/Team5/result",params="next")		
		public String send5(
				@RequestParam String inputText,
				@ModelAttribute("team5Account") Team5Account team5Account,
				Model model
				) throws Throwable {
			end = typing.getLocalTime();
			
			//sample文字列と入力された文字を入力
			
			typing.checkArticle(inputText,sample);
			
			//typing.getPer();
			//%表示
			//typing.takeTimer();
			double Per = typing.getPer() * 100;
			String PerSt = String.format("%2.1f%%",Per);
			model.addAttribute("Per",PerSt);
			model.addAttribute("Cor",typing.getCorrect());
			model.addAttribute("Wor",typing.getWrong());
			System.out.println("ログイン中アカウント : " +team5Account);
			model.addAttribute("Min",typing.getcalcM(start,end));
			model.addAttribute("inputText",inputText);
			//throw new Exception();
			accountServ.addScore(team5Account,(int)typing.getcalcM(start,end));
			System.out.println("ログイン中アカウント : " +team5Account);
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
		public String send4() throws Throwable{
	
			return "team5/Team5menu";		
			}


}
