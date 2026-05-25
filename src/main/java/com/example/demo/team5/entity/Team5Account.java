package com.example.demo.team5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Team5_LOGIN_TBL")
@Data
public class Team5Account {
	@Id
	@NotBlank(message = "ユーザーネームを入力してください")
	@Max(value = 30 , message = "ユーザ名は30字以下にしてください。")
	private String userId;
	
	@NotBlank(message = "パスワードを入力してください")
    @Size(min = 10, max = 30, message = "パスワードは10文字以上30文字以内で入力してください")
	private String passWord;
}
