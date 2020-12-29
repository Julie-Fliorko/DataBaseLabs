package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.FunFact;

@Repository
public interface FunFactRepository extends JpaRepository<FunFact, Integer> {
}
