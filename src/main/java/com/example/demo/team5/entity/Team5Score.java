package com.example.demo.team5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Team5_typing_tbl")
@Data
public class Team5Score {
	@Id
	public Integer acId;
	public Double time;
	public Integer correctCount;
	public Integer missCount;
	public Integer perMinutes;
	
}