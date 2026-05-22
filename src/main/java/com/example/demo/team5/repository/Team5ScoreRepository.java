package com.example.demo.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team5.entity.Team5Score;

@Repository

public interface Team5ScoreRepository extends JpaRepository<Team5Score, Integer>{
}