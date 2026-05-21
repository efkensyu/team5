package com.example.demo.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team5.entity.Team5_typing;

@Repository
public interface Team5TypingRepository extends JpaRepository<Team5_typing, Integer>{
	
}