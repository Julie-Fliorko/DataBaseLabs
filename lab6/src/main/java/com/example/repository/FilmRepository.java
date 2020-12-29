package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
}