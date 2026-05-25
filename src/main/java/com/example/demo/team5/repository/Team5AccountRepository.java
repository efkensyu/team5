package com.example.demo.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team5.entity.Team5Account;

@Repository
public interface Team5AccountRepository extends JpaRepository <Team5Account,String>{
	public boolean existsByUserId(String UserId);
	public Team5Account findByPassWord(String UserId);
	public void setScore(Integer score);
	
}
