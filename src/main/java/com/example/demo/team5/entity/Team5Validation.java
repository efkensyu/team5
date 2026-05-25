package com.example.demo.team5.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Team5Validation {
	 @NotBlank(message = "ユーザーネームを入力してください")
	    private String username;

	        @NotBlank(message = "パスワードを入力してください")
	    @Size(min = 10, max = 30, message = "パスワードは10文字以上30文字以内で入力してください")
	    private String password;

	       public String getUsername() { return username; }
	    public void setUsername(String username) { this.username = username; }
	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }




	
}
