package com.example.demo.team5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team5.entity.Team5Acount;

@Repository
public interface Team5AcountRepository extends JpaRepository <Team5Acount,Integer>{

}
