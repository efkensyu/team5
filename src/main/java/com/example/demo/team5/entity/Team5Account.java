package com.example.demo.team5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Team5_LOGIN_TBL")
@Data
public class Team5Account {
	@Id
	private String loginId;
	private String passWord;
	
	

}
