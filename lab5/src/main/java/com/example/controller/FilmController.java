package com.example.controller;

import com.example.model.dao.implementation.FilmDAO;
import com.example.model.entity.Film;

import java.sql.SQLException;
import java.util.List;

public class FilmController implements GenericController<Film>{
    FilmDAO dao = new FilmDAO();

    @Override
    public List<Film> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Film findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Film film) throws SQLException {
        dao.create(film);
    }

    @Override
    public void update(Integer id, Film film) throws SQLException {
        dao.update(id, film);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}