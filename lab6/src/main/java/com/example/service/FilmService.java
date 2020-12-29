package com.example.service;

import com.example.repository.FilmRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.domain.Film;

@Service
public class FilmService extends AbstractService<Film, Integer> {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


    @Override
    protected JpaRepository<Film, Integer> getRepository() {
        return filmRepository;
    }

}