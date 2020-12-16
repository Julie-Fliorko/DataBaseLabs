package com.example.controller;

import com.example.model.dao.implementation.CountryDAO;
import com.example.model.entity.Country;

import java.sql.SQLException;
import java.util.List;

public class CountryController implements GenericController<Country>{
    CountryDAO dao = new CountryDAO();

    @Override
    public List<Country> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Country findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(Country country) throws SQLException {
        dao.create(country);
    }

    @Override
    public void update(Integer id, Country country) throws SQLException {
        dao.update(id, country);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}