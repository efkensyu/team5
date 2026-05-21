package com.example.demo.team5.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Team5ScoreRepository extends JpaRepository<Team5ScoreRepository, Integer> {
	
}