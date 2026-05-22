package com.example.demo.team5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Team5_typing_tbl")
@Data
public class Team5_typing {
	@Id
	@Column(name = "TYPING_ID")
	private Integer typingId;
	private String typingBody;
}
